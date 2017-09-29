(function() {

	let todoApp = angular.module("todo");

	let ToDoController = function($scope, ToDoService) {
		$scope.todos = [];
		$scope.msg = "";
		$scope.error = "";
		$scope.theme = "panel-primary"
		$scope.themes = [ 'panel-default', 'panel-primary', 'panel-success',
				'panel-info', 'panel-warning', 'panel-danger' ]

		let onComplete = function(data) {
			$scope.todos = data.data._embedded.toDos;
		}

		let onError = function(reason) {
			$scope.error = "could not fetch data from server."+reason
		}

		$scope.loadAllTodo = function() {
			ToDoService.findAll().then(onComplete, onError);
		}

		$scope.loadAllTodo();

		$scope.add = function(event) {
			if ($scope.msg != "" && event.which === 13) {
				let todo = {
					"msg" : $scope.msg,
					"status" : "Pending"
				};
				ToDoService.add(todo).then(function(data) {
					$scope.todos.push(data.data);
					$scope.msg = "";
				}, onError);
			}
		}

		$scope.update = function(todo) {

			ToDoService.update(todo).then(function(data) {
				var oldList = $scope.todos;
				$scope.todos = [];
				angular.forEach(oldList, function(x) {
					if (x.id != data.id)
						$scope.todos.push(x);
					else
						$scope.todos.push(data.data);
				});
			}, onError);
		}

		$scope.remove = function(todo) {
			console.debug(todo);
			ToDoService.remove(todo.id).then(function(data) {
				var oldList = $scope.todos;
				$scope.todos = [];
				angular.forEach(oldList, function(x) {
					if (x.id != todo.id)
						$scope.todos.push(x);
				});
			}, onError)
		}

		$scope.doneEditing = function(todo) {
			todo.editing = false;
		}

		$scope.edit = function(todo) {
			todo.editing = true;
		}

		$scope.deleteAll = function() {
			angular.forEach($scope.todos, function(x) {
				$scope.remove(x);
			});
		}

		$scope.completeAll = function() {
			var oldList = $scope.todos;
			angular.forEach(oldList, function(x) {
				x.status = "Completed";
				$scope.update(x);
			});
		}

		$scope.getClass = function(todo) {
			if (todo.status == "Completed") {
				return "btn btn-success";
			} else
				return "btn-warning"
		}
		
		$scope.hideError = function(){
			$scope.error = "";
		}
	}
	todoApp.controller("ToDoController", [ '$scope', 'ToDoService',
			ToDoController ]);
})();