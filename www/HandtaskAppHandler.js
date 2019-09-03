var exec = require('cordova/exec');
var HandtaskAppHandler = {
    getApps: function (packageName, success, error) {
        exec(success, error, 'HandtaskAppHandler', 'getApps', [packageName]);
    },
    startApp: function (packageName, activityName, params, success, error) {
        exec(success, error, 'HandtaskAppHandler', 'startApp', [packageName, activityName, params]);
    }
}
module.exports = HandtaskAppHandler;