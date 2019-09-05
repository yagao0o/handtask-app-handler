var exec = require('cordova/exec');
var HandtaskAppHandler = {
    getApps: function (packageName, isOut, success, error) {
        exec(success, error, 'HandtaskAppHandler', 'getApps', [packageName, isOut]);
    },
    startApp: function (packageName, activityName, params, isOut, success, error) {
        exec(success, error, 'HandtaskAppHandler', 'startApp', [packageName, activityName, params, isOut]);
    }
}
module.exports = HandtaskAppHandler;