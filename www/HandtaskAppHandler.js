var exec = require('cordova/exec');
var HandtaskAppHandler = {
    coolMethod: function (arg0, success, error) {
        exec(success, error, 'HandtaskAppHandler', 'coolMethod', [arg0]);
    },
    getApps: function (packageName, success, error) {
        exec(success, error, 'HandtaskAppHandler', 'getApps', [packageName]);
    },
    startApp: function (packageName, activityName, params, success, error) {
        exec(success, error, 'HandtaskAppHandler', 'startApp', [packageName, activityName, params]);
    }
}
module.exports = HandtaskAppHandler;