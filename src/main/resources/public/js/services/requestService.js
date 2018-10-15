app.service('requestService', function ($http) {

    this.get = function (url) {
        return $http.get(url);
    }

    this.post = function (url, body) {
        return $http({
            url: url,
            data: body,
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    }

    this.put = function (url, body) {
        return $http({
            url: url,
            method: "PUT",
            data: body,
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    }

    this.delete = function (url) {
        return $http({
            url: url,
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    }

});