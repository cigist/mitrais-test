var app = angular.module("myApp", ["ngRoute"]);
var url="http://localhost:8080/api/"
app.config(function ($routeProvider) {
  $routeProvider
    .when("/login", {
      templateUrl: "pages/login.html"
    })
    .when("/", {
      templateUrl: "pages/register.html"
    })
    .otherwise({ redirectTo: '/' });
});
app.constant("moment", moment);
app.controller('regCtrl', function ($scope, moment,$http,$window) {
  $scope.regFailed =false;
  $scope.formDis =false;
  $scope.showLogin = false;
  $scope.message =null;
  $scope.yrs="00";
  $scope.dte="00";
  $scope.yrs="00";
  $scope.months = ['01','02','03','04','05','06','07','08','09','10','11','12'];
  $scope.years = [1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015];
  $scope.dates = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'];
  $scope.doRegister = function () {
    var dob;
    if($scope.yrs !=null| $scope.mth!=null|$scope.dte!=null){
      dob=$scope.yrs+'-'+$scope.mth+'-'+$scope.dte
    }
    var data={
      phoneNumber:$scope.mobile,
      firstname:$scope.firstname,
      lastname:$scope.lastname,
      dateOfBirth:dob,
      gender:$scope.gender,
      email:$scope.email
    }
    $http.post(url+"register/", JSON.stringify(data)).then(function (response) {
      // This function handles success
        if(response.data.code ==200){
          if(response.data.status=='OK'){
            $scope.regFailed=false;
            $scope.formDis = true;
            $scope.showLogin=true;
          }else{
            $scope.regFailed=true;
            $scope.formDis = false;
            $scope.showLogin=false;
            $scope.message = response.data.message;
          }          
        }else{
          $scope.regFailed=true;
          $scope.formDis = false;
          $scope.showLogin=false;
          $scope.message ="Invalid registration";
        }
      }, function (response) {
        $scope.formDis = false;
        $scope.showLogin=false;
        $scope.regFailed=true;
      // this function handles error
      });
    }
    
});

app.controller('loginCtrl', function ($scope) {


});