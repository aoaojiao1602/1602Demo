! function(n, e) {
	"object" == typeof exports && "object" == typeof module ? module.exports = e() : "function" == typeof define && define.amd ? define([], e) : "object" == typeof exports ? exports.device = e() : n.device = e()
}(window, function() {
	return function(n) {
		var e = {};

		function o(t) {
			if(e[t]) return e[t].exports;
			var i = e[t] = {
				i: t,
				l: !1,
				exports: {}
			};
			return n[t].call(i.exports, i, i.exports, o), i.l = !0, i.exports
		}
		return o.m = n, o.c = e, o.d = function(n, e, t) {
			o.o(n, e) || Object.defineProperty(n, e, {
				configurable: !1,
				enumerable: !0,
				get: t
			})
		}, o.r = function(n) {
			Object.defineProperty(n, "__esModule", {
				value: !0
			})
		}, o.n = function(n) {
			var e = n && n.__esModule ? function() {
				return n.default
			} : function() {
				return n
			};
			return o.d(e, "a", e), e
		}, o.o = function(n, e) {
			return Object.prototype.hasOwnProperty.call(n, e)
		}, o.p = "", o(o.s = 1)
	}([function(n, e, o) {
		"use strict";
		o.r(e);
		var t = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function(n) {
				return typeof n
			} : function(n) {
				return n && "function" == typeof Symbol && n.constructor === Symbol && n !== Symbol.prototype ? "symbol" : typeof n
			},
			i = window.device,
			r = {},
			a = [];
		window.device = r;
		var c = window.document.documentElement,
			d = window.navigator.userAgent.toLowerCase(),
			u = ["googletv", "viera", "smarttv", "internet.tv", "netcast", "nettv", "appletv", "boxee", "kylo", "roku", "dlnadoc", "roku", "pov_tv", "hbbtv", "ce-html"];

		function l(n) {
			return -1 !== d.indexOf(n)
		}

		function s(n) {
			return c.className.match(new RegExp(n, "i"))
		}

		function f(n) {
			var e = null;
			s(n) || (e = c.className.replace(/^\s+|\s+$/g, ""), c.className = e + " " + n)
		}

		function b(n) {
			s(n) && (c.className = c.className.replace(" " + n, ""))
		}

		function p() {
			r.landscape() ? (b("portrait"), f("landscape"), w("landscape")) : (b("landscape"), f("portrait"), w("portrait")), h()
		}

		function w(n) {
			for(var e in a) a[e](n)
		}
		r.macos = function() {
			return l("mac")
		}, r.ios = function() {
			return r.iphone() || r.ipod() || r.ipad()
		}, r.iphone = function() {
			return !r.windows() && l("iphone")
		}, r.ipod = function() {
			return l("ipod")
		}, r.ipad = function() {
			return l("ipad")
		}, r.android = function() {
			return !r.windows() && l("android")
		}, r.androidPhone = function() {
			return r.android() && l("mobile")
		}, r.androidTablet = function() {
			return r.android() && !l("mobile")
		}, r.blackberry = function() {
			return l("blackberry") || l("bb10") || l("rim")
		}, r.blackberryPhone = function() {
			return r.blackberry() && !l("tablet")
		}, r.blackberryTablet = function() {
			return r.blackberry() && l("tablet")
		}, r.windows = function() {
			return l("windows")
		}, r.windowsPhone = function() {
			return r.windows() && l("phone")
		}, r.windowsTablet = function() {
			return r.windows() && l("touch") && !r.windowsPhone()
		}, r.fxos = function() {
			return(l("(mobile") || l("(tablet")) && l(" rv:")
		}, r.fxosPhone = function() {
			return r.fxos() && l("mobile")
		}, r.fxosTablet = function() {
			return r.fxos() && l("tablet")
		}, r.meego = function() {
			return l("meego")
		}, r.cordova = function() {
			return window.cordova && "file:" === location.protocol
		}, r.nodeWebkit = function() {
			return "object" === t(window.process)
		}, r.mobile = function() {
			return r.androidPhone() || r.iphone() || r.ipod() || r.windowsPhone() || r.blackberryPhone() || r.fxosPhone() || r.meego()
		}, r.tablet = function() {
			return r.ipad() || r.androidTablet() || r.blackberryTablet() || r.windowsTablet() || r.fxosTablet()
		}, r.desktop = function() {
			return !r.tablet() && !r.mobile()
		}, r.television = function() {
			for(var n = 0; n < u.length;) {
				if(l(u[n])) return !0;
				n++
			}
			return !1
		}, r.portrait = function() {
			return screen.orientation && Object.prototype.hasOwnProperty.call(window, "onorientationchange") ? screen.orientation.type.includes("portrait") : window.innerHeight / window.innerWidth > 1
		}, r.landscape = function() {
			return screen.orientation && Object.prototype.hasOwnProperty.call(window, "onorientationchange") ? screen.orientation.type.includes("landscape") : window.innerHeight / window.innerWidth < 1
		}, r.noConflict = function() {
			return window.device = i, this
		}, r.ios() ? r.ipad() ? f("ios ipad tablet") : r.iphone() ? f("ios iphone mobile") : r.ipod() && f("ios ipod mobile") : r.macos() ? f("macos desktop") : r.android() ? r.androidTablet() ? f("android tablet") : f("android mobile") : r.blackberry() ? r.blackberryTablet() ? f("blackberry tablet") : f("blackberry mobile") : r.windows() ? r.windowsTablet() ? f("windows tablet") : r.windowsPhone() ? f("windows mobile") : f("windows desktop") : r.fxos() ? r.fxosTablet() ? f("fxos tablet") : f("fxos mobile") : r.meego() ? f("meego mobile") : r.nodeWebkit() ? f("node-webkit") : r.television() ? f("television") : r.desktop() && f("desktop"), r.cordova() && f("cordova"), r.onChangeOrientation = function(n) {
			"function" == typeof n && a.push(n)
		};
		var m = "resize";

		function y(n) {
			for(var e = 0; e < n.length; e++)
				if(r[n[e]]()) return n[e];
			return "unknown"
		}

		function h() {
			r.orientation = y(["portrait", "landscape"])
		}
		Object.prototype.hasOwnProperty.call(window, "onorientationchange") && (m = "orientationchange"), window.addEventListener ? window.addEventListener(m, p, !1) : window.attachEvent ? window.attachEvent(m, p) : window[m] = p, p(), r.type = y(["mobile", "tablet", "desktop"]), r.os = y(["ios", "iphone", "ipad", "ipod", "android", "blackberry", "windows", "fxos", "meego", "television"]), h(), e.default = r
	}, function(n, e, o) {
		n.exports = o(0)
	}]).default
});
//# sourceMappingURL=../../../../maps/routes/shared/libs/current-device.umd.min.js.map