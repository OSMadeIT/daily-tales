var app = angular.module('myApp', ['ui.router']);


app.config(function($stateProvider) {
  var storyState = {
    name: 'stories',
    url: '/stories',
    templateUrl: 'partials/newstory.html'
  };
  
  var editStoryState = {
    name: 'edit',
    url: '/edit',
    templateUrl: 'partials/editstory.html'
  };
  
  var homeState = {
    name: 'home',
    url: '/home',
    templateUrl: 'partials/home.html'
  };
  
   $stateProvider.state(homeState);
   $stateProvider.state(storyState);  
   $stateProvider.state(editStoryState);
});

app.controller('myCtrl', function($scope, $http, $state) {
    $http({
        method : "GET",
        url : "api/stories/list"
    }).then(function mySuccess(response) {
        $scope.stories = response.data;
    }, function myError(response) {
        $scope.stories = response.statusText;
    });
    
    $scope.sendData = function() {
 
    var storyData = {"title": $scope.storyTitle,
                "story": $scope.storyBody,
                "createdAt": "2018-09-10T08:10:04Z[UTC]"
            };    
    $http.post('api/stories/create', storyData).success(function (data) {
     $state.go('home');
  });
};

    $scope.deleteData = function(storyId) {

        var storo = { 
            id: storyId 
        };    
        $http.delete('api/stories/delete/'  + storo.id)

};

    $scope.updateData = function(storoId) {
        var Id = {id: storoId};
        var editedStory = {
            "title": $scope.story.title,
            "story": $scope.story.story
        };    
        $http.put('api/stories/update/'  + Id.id, editedStory).then(function mySuccess(response) {
        $state.go('/home');
    }, function myError(response) {
        $scope.myWelcome = response.statusText;
      });

    };

});
