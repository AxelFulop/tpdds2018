package modelo;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

public class Optimizador {
    
    public List<Double> optimizar(List<Dispositivo> dispositivos, Double limiteMensual) {
    	
        // Filtrar dispositivos sin restricciones
        List<Dispositivo> dispositivosOptimizables = obtenerDispositivosOptimizables(dispositivos);
        
        // Funcion economica-objetivo
        double[] arrayObjetivo = new double[dispositivosOptimizables.size()];
        Arrays.fill(arrayObjetivo, 1);
        LinearObjectiveFunction funcionZ = new LinearObjectiveFunction(arrayObjetivo, 0);
        
        // RESTRICCIONES
        List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
        
        // Restriccion mensual
        double[] coeficientesRestriccion = arrayDeCoeficientes(dispositivosOptimizables);
        LinearConstraint restriccionMensual = new LinearConstraint(coeficientesRestriccion, Relationship.LEQ, limiteMensual);
        restricciones.add(restriccionMensual);
        
        // Restricciones por dispositivo
        
        dispositivosOptimizables.forEach(dispositivo -> {
            LinearConstraint restriccionSuperior = generarRestriccion(dispositivosOptimizables,dispositivo,Relationship.LEQ);
            LinearConstraint restriccionInferior = generarRestriccion(dispositivosOptimizables,dispositivo,Relationship.GEQ);
            restricciones.add(restriccionSuperior);
            restricciones.add(restriccionInferior);
        });
        
        
        SimplexSolver solver = new SimplexSolver();
        PointValuePair solucion = solver.optimize(new MaxIter(100)                        // Numero maximo de iteraciones
                                                , funcionZ                                // Funcion objetivo
                                                , new LinearConstraintSet(restricciones)  // Restricciones
                                                , GoalType.MAXIMIZE                       // Objetivo (Maximizar)
                                                , new NonNegativeConstraint(true));       // Restriccion adicional ( solo positivos )
        
        
        List<Double> solucionFinal = listFromDoubleArray(solucion.getPoint());
        return solucionFinal;
    }
    
    public List<Dispositivo> obtenerDispositivosOptimizables(List<Dispositivo> dispositivos){
    	List<Dispositivo> dispositivosOptimizables = dispositivos
                .stream()
                .filter(disp -> {
                    try {
                        disp.getRestriccion();
                        return true;
                    }catch(Exception e){
                        return false;
                    }
                }).collect(Collectors.toList());
    	return dispositivosOptimizables;
    }
    
    private List<Double> listFromDoubleArray(double[] array) {
        List<Double> resultado = new ArrayList<Double>();
        for(int i = 0; i < array.length; i++) {
            resultado.add(new Double(array[i]));
        }
        return resultado;
    }

    private LinearConstraint generarRestriccion(List<Dispositivo> dispositivos, Dispositivo dispositivo, Relationship relacion) {
        Integer posicionEnLista = dispositivos.indexOf(dispositivo);
        double[] arrayRestriccion = new double[dispositivos.size()];
        Arrays.fill(arrayRestriccion, 0d);
        arrayRestriccion[posicionEnLista] = 1;
        double limite;
        if(relacion == Relationship.LEQ) {
            limite = dispositivos.get(posicionEnLista).getRestriccion().getCotaSuperior();
        }else if(relacion == Relationship.GEQ){
            limite = dispositivos.get(posicionEnLista).getRestriccion().getCotaInferior();
        }else {
            throw new RuntimeException ("Relacion no admitida");
        }

        LinearConstraint restriccion = new LinearConstraint(arrayRestriccion, relacion, limite);
        return restriccion;
    }

    private double[] arrayDeCoeficientes(List<Dispositivo> dispositivos) {
        Double[] coeficientes = new Double[dispositivos.size()];
        coeficientes = dispositivos.stream()
                                   .map(dispositivo -> dispositivo.getKwh())
                                   .collect(Collectors.toList())
                                   .toArray(coeficientes);
        double[] coeficientesPrimitivos = ArrayUtils.toPrimitive(coeficientes);
        return coeficientesPrimitivos;
    }

	public Map<Dispositivo, Double> dispositivosYConsumoRecomendado(List<Dispositivo> dispositivos,Double limiteMensual) {
        List<Dispositivo> dispositivosOptimizables = dispositivos
                .stream()
                .filter(dispositivo -> {
                    try {
                        dispositivo.getRestriccion();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }).collect(Collectors.toList());


        Map<Dispositivo, Double> mapa = new HashMap<Dispositivo, Double>();
        List<Double> consumos = optimizar(dispositivos, limiteMensual);
        for (int i = 0; i < dispositivosOptimizables.size(); i++) {
            mapa.put(dispositivosOptimizables.get(i), consumos.get(i));
        }
        return mapa;
    }
}

