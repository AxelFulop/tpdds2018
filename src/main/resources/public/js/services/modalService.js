app.service('myModalService', function ($uibModal) {

    this.openModal = function (templateUrl, controller, data) {
        this.modalInstance = $uibModal.open({
            animation: true,
            templateUrl: templateUrl,
            controller: controller,
            resolve: {
                data: () => data
            }
        });
        return this.modalInstance;
    }
});