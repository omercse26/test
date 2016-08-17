//! ################################################################
//! This file contains both original and merged/adapted code .
//! Except where indicated, all code is 
//! Copyright (c) 2004-2006 Amazon.com, Inc., and its Affiliates.
//! All Rights Reserved.
//! Not to be reused without permission
if (typeof gsN2ImageHost=='undefined') { gsN2ImageHost='http://g-images.amazon.com/images/G/01/'; }
var gbN2LibMonMigrated = true;
var N2Loaded = false;
var n2LMStart = new Date();
var gaN2JSLibPaths =  [];
var gaN2JSLibIds =  [];
var gaN2CSSLibs = [];
var gaN2CSSLibPaths = [];
var gaN2JSLibs =  [];
var oTheDoc = document;
var oTheBody = oTheDoc.body;
var oTheHead = document.getElementsByTagName('head').item(0);
var n2sRTW1='onload';
var n2sRTWTBS='simplepopoverloaded';
function N2Initializer () {
this.aHandlers = new Array();
this.aEventsRun = new Array();
this.bCoreLoaded = false;
}
new N2Initializer ();
N2Initializer.prototype.runThisWhen  = function (sWhen, fFn, sComment) {
if ( (typeof fFn != 'function') || fFn == null) return false;
sWhen = sWhen.toLowerCase();
if ( (sWhen =='inbody' && document.body) || this.aEventsRun[sWhen] ){
fFn();
} else {
this.aHandlers[this.aHandlers.length] = { sWhen: sWhen, fFn: fFn, sComment: sComment };
}
return true
}
N2Initializer.prototype.initializeThis = N2Initializer.prototype.runThisWhen
N2Initializer.prototype.loadThisWhen  = function (sWhen, sURL, sID, sComment) {
sWhen = sWhen.toLowerCase();
goN2LibMon.monitorLoad (sID);
if ( sWhen =='now' ) {
n2LoadScript(sURL, true, sID);
} else {
this.aHandlers[this.aHandlers.length] = { sWhen: sWhen, sURL: sURL, sID: sID, sComment: sComment };
}
return true
}
N2Initializer.prototype.run = function (sWhen) {
sWhen = (typeof sWhen == 'undefined') ? null : sWhen;
sWhen = sWhen.toLowerCase();
this.aEventsRun[sWhen] = true;
if (sWhen == 'coreloaded') { this.bCoreLoaded=true; }
if (window.goN2Debug) goN2Debug.info("N2Initializer called with " + (sWhen ? "'"+sWhen+"'" : "null"));
var aH = this.aHandlers;
var len = aH.length;
for (var i=0;i<len;i++) {
var oTmp = aH[i];
if ((oTmp.bCalled != true) &&
(oTmp.fFn || oTmp.sURL) &&
( (sWhen == null) || (oTmp.sWhen && (oTmp.sWhen == sWhen)))
) {
if ((oTmp.sWhen == 'coreloaded') && !this.bCoreLoaded) continue;
if (window.goN2Debug) ;   
if (oTmp.fFn) {
oTmp.fFn();
} else if (oTmp.sURL) {
n2LoadScript(oTmp.sURL, true, oTmp.sID);
} 
oTmp.bCalled = true;
}
}
}
goN2Initializer = new N2Initializer();
function  n2RunThisWhen (sWhen, fFn, sComment) {
goN2Initializer.runThisWhen(sWhen, fFn, sComment);
}
function n2LoadThisWhen  (sWhen, sURL, sID, sComment) {
goN2Initializer.loadThisWhen(sWhen, sURL, sID, sComment);
}
function n2RunIfLoaded (sLibID, fFn, sComment) {
n2RunThisWhen(sLibID+'loaded', fFn, 'sequenced init of '+ sComment);
}
function n2LoadScript (sURL, bLocalCacheOK, sLibID) {
if (sLibID) { goN2LibMon.requestLoad (sLibID); }
var e = oTheDoc.createElement("script");
e.type="text/javascript";
if (bLocalCacheOK)	{
e.src = sURL;
} else {
e.src = sURL + (sURL.indexOf('?') == -1 ? '?' : '&') + 'lt='+ new Date().getTime();
}
oTheHead.appendChild(e);
}
function N2LibraryMonitor() {
this.aLibs = {};
this.bJSLoaded=false;
this.bCSSLoaded=false;
this.sNotLoaded ='A desirable part of the page did not load. Please refresh the page to try again. \n';
this.nTimer=null;
this.nTimeoutMs = 10000;
}
new N2LibraryMonitor();
N2LibraryMonitorProto = N2LibraryMonitor.prototype;
N2LibraryMonitor.prototype.monitorLoad = function (sLibID) {
this.aLibs[sLibID] = { sID: sLibID, nDuration: -1 };
}
N2LibraryMonitor.prototype.requestLoad = function (sLibID, sFeatureID) {
var oTmp = this.aLibs[sLibID];
if (oTmp) { oTmp.nDuration= -2; }
this.resetTimer();
}
N2LibraryMonitor.prototype.beginLoad = function (sLibID, sFeatureID) {
var oTmp = this.aLibs[sLibID];
if (oTmp) { 
oTmp.sFeature = sFeatureID;
oTmp.nBegin = new Date().getTime();
oTmp.nDuration= -3;
}
};
N2LibraryMonitor.prototype.endLoad = function (sLibID, nStatus) {
var oTmp = this.aLibs[sLibID];
if (oTmp) { oTmp.nDuration = new Date().getTime() - oTmp.nBegin; oTmp.bLoaded=true;}
var bALL;
if (bALL=this.allLibsLoaded()) {
this.clearTimer();
} else {
this.resetTimer();
}
goN2Initializer.run(sLibID+'loaded');
if (bALL) {
goN2Initializer.run('lastlibraryloaded');
}
}
N2LibraryMonitorProto.clearTimer=function() {
if (this.nTimer) {
clearTimeout(this.nTimer);
this.nTimer = null;
}
}
N2LibraryMonitorProto.resetTimer=function() {
if (this.nTimer) { 
clearTimeout(this.nTimer);
}
this.nTimer = setTimeout(n2LibraryLoadTimeout, this.nTimeoutMs);
}
function n2LibraryLoadTimeout() {
goN2Initializer.run('libraryloadfailed');
}
N2LibraryMonitor.prototype.allLibsLoaded = function () {
var bAllLoaded=true;
for (var key in this.aLibs) {
if (this.aLibs[key] && this.aLibs[key].nDuration <0) { bAllLoaded=false; }
}
this.bJSLoaded = bAllLoaded;
return bAllLoaded;
}
N2LibraryMonitor.prototype.confirmJSLoaded = function() { return this.bJSLoaded; }
N2LibraryMonitor.prototype.confirmCSSLoaded = function() { this.bCSSLoaded=true; }
N2LibraryMonitor.prototype.isJSLoaded = function() { return this.bJSLoaded; }
N2LibraryMonitor.prototype.isCSSLoaded = function() { return this.bCSSLoaded; }
N2LibraryMonitor.prototype.status = function() { 
if (this.bJSLoaded) return "OK!";
else return this.sNotLoaded;
}
N2LibraryMonitor.prototype.stats = function() { return "N/A"; };
goN2LibMon = new N2LibraryMonitor();
var n2LLStop = new Date();
var n2LMStop = new Date();
function N2ConfigBase() { 
this.getValue = function(id,d) {
if(typeof this[id] != 'undefined') { return this.id; }
else { return d; } } }
var goN2ConfigBase = new N2ConfigBase();
gaN2CSSLibPaths.push(
'http://g-images.amazon.com/images/G/01/nav2/prod/n2CoreCSS/n2CoreCSS-n2v1-11682.css');
gaN2JSLibPaths.push(
'http://g-images.amazon.com/images/G/01/nav2/prod/n2CoreLibs/n2CoreLibs-utilities-28861.js',
'http://g-images.amazon.com/images/G/01/nav2/prod/n2CoreLibs/n2CoreLibs-events-8980.js',
'http://g-images.amazon.com/images/G/01/nav2/prod/n2CoreLibs/n2CoreLibs-simplePopover-49145.js');
gaN2JSLibIds.push(
'utilities',
'events',
'simplePopover');
(function()
{
if (gsN2ImageHost != 'http://g-images.amazon.com/images/G/01/')
{
var i;
for (i in gaN2CSSLibPaths)
gaN2CSSLibPaths[i] = gaN2CSSLibPaths[i].replace(/^http:\/\/g-images.amazon.com\/images\/G\/01\//, gsN2ImageHost);
for (i in gaN2JSLibPaths)
gaN2JSLibPaths[i] = gaN2JSLibPaths[i].replace(/^http:\/\/g-images.amazon.com\/images\/G\/01\//, gsN2ImageHost);
}
}());
(function()
{
var i;
var sTags = "";
var bIsSafari = navigator.userAgent.match(/Safari/);
for (i in gaN2CSSLibPaths)
{
sTags += '<link href="'+gaN2CSSLibPaths[i]+'" type="text/css" rel="stylesheet">\n';
}
for (i in gaN2JSLibPaths)
{
goN2LibMon.monitorLoad(gaN2JSLibIds[i]);
var sScript = '<script src="'+gaN2JSLibPaths[i]+'" type="text/javascript"><\/script>\n';
if (bIsSafari) document.write(sScript);
else sTags += sScript;
}
document.write(sTags);
}());
var goCust = new Object();
goCust.isLoggedIn = function() { return false; }
var goN2Explorer;
var gaTD;
var goN2AC;
n2RunThisWhen (n2sRTWTBS, 
function() {
oAllCatPopover = new N2SimplePopover();
goN2Events.registerFeature('two-tabs', 'oAllCatPopover', 'n2MouseOverHotspot', 'n2MouseOutHotspot'); 
goN2Events.setFeatureDelays('two-tabs',200, 400, 200);
oAllCatPopover.initialize('AllCatPopoverDiv', 'oAllCatPopover',null,null,'below','c'); 
}, 
'All Categories popover');
n2RunThisWhen(n2sRTW1, 
function() {
if (!window.gaTD) gaTD = new Array();
N2Loaded = goN2LibMon.isJSLoaded(); 
}, "Last Init");