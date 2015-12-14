window._BFD = window._BFD || {};
_BFD.addEvent = function(e, d, f) {
	if (e.addEventListener) {
		e.addEventListener(d, f, false)
	} else {
		if (e.attachEvent) {
			e.attachEvent("on" + d, function() {
				f.call(e)
			})
		} else {
			e["on" + d] = f
		}
	}
};
_BFD.removeEvent = function(e, d, f) {
	if (e.removeEventListener) {
		e.removeEventListener(d, f, false)
	} else {
		if (e.detachEvent) {
			e.detachEvent("on" + d, function() {
				f.call(e)
			})
		} else {
			e["on" + d] = null
		}
	}
};
_BFD.createElement = function(g, f) {
	var h = document.createElement(g);
	if (f) {
		for ( var e in f) {
			if (f.hasOwnProperty(e)) {
				if (e === "class" || e === "className") {
					h.className = f[e]
				} else {
					if (e === "style") {
						h.style.cssText = f[e]
					} else {
						h.setAttribute(e, f[e])
					}
				}
			}
		}
	}
	return h
};
_BFD.loadScript = function(d, c) {
	setTimeout(function() {
		var a = _BFD.createElement("script", {
			src : d,
			type : "text/javascript"
		});
		if (a.readyState) {
			_BFD.addEvent(a, "readystatechange", function() {
				if (a.readyState === "loaded" || a.readyState === "complete") {
					if (c) {
						c()
					}
					_BFD.removeEvent(a, "readystatechange", arguments.callee)
				}
			})
		} else {
			_BFD.addEvent(a, "load", function() {
				if (c) {
					c()
				}
				_BFD.removeEvent(a, "load", arguments.callee)
			})
		}
		document.getElementsByTagName("head")[0].appendChild(a)
	}, 0)
};
_BFD.getByAttribute = function(l, k, j) {
	var i = [], j = (j) ? j : document, n = j.getElementsByTagName("*"), o = new RegExp(
			"\\b" + k + "\\b", "i");
	for (var p = 0; p < n.length; p++) {
		var m = n[p];
		if (l === "className" || l === "class") {
			if (o.test(m.className)) {
				i.push(m)
			}
		} else {
			if (m.getAttribute(l) === k) {
				i.push(m)
			}
		}
	}
	return i
};
_BFD.getByClass = function(c, d) {
	return _BFD.getByAttribute("className", c, d)
};
_BFD.getById = function(b) {
	if (typeof b === "string" && !!b) {
		return document.getElementById(b)
	}
};
_BFD.loadCss = function(d) {
	var c = _BFD.createElement("link", {
		href : d,
		rel : "stylesheet",
		type : "text/css"
	});
	document.getElementsByTagName("head")[0].appendChild(c)
};
_BFD.insertAfter = function(g, h) {
	var e = h.parentNode;
	if (e.lastChild == h) {
		e.appendChild(g)
	} else {
		var f = h.nextElementSibling || h.nextSibling;
		e.insertBefore(g, f)
	}
};
_BFD.Banner = function(b, d, a) {
	this.callback = d;
	this.args = a;
	this.positionstr = b.pos_dom;
	this.bid = b.bid;
	if (b.json_args) {
		this.json_str = c(b.json_args)
	} else {
		this.json_str = "{}"
	}
	function c(f) {
		var g = [];
		for ( var e in f) {
			g.push('"' + e + '":"' + f[e] + '"')
		}
		return "{" + g.join(",") + "}"
	}
};
_BFD.handleResults = function(e, g) {
	if (g && g[2] && g[2].length > 0) {
		var f = g[2];
		for (var b = 0; b < f.length; b++) {
			var h = e[b];
			var c = f[b][3];
			var a = f[b][2];
			var j = h.bid;
			var d = h.args;
			if (c && c.length > 0) {
				h.callback(c, a, j, d)
			}
		}
	}
};
_BFD.parseBanners = function(b, f, g) {
	var e = [], a = [];
	for (var c = 0, d; d = f[c++];) {
		e.push(d.bid);
		if (d.json_str && d.json_str.length > 0 && d.json_str != "{}") {
			a.push("rec_" + d.bid + "$" + d.json_str)
		} else {
			a.push("rec_" + d.bid)
		}
	}
	if (f.length) {
		b.bidlst = e.join("|");
		b.req = a.join("|");
		g.send(b, function(h) {
			_BFD.handleResults(f, h)
		})
	}
};
_BFD.invoketime = 0;
_BFD
		.loadScript(
				("https:" == document.location.protocol ? "https://ssl-static"
						: "http://static")
						+ ".baifendian.com/api/2.0/bcore.min.js",
				function() {
					var a = (function() {
						function b() {
							var f = new $Core(function() {
							});
							_BFD.bfd_show = function(k, i, h, j) {
								var g = _BFD.show_recommended(j, h);
								_BFD.show_template(k, g, i, h, j)
							};
							_BFD.show_recommended = function(h, g) {
							};
							_BFD.show_content = function(i, g, h) {
							};
							_BFD.show_template = function(g, k, i, h, j) {
							};
							_BFD.banners = {
								dt : [],
								ls : [],
								sc : [],
								odr : [],
								hp : [],
								sr_n : [],
								sr_y : [],
								ap : [],
								chl : [],
								pm : [],
								dft : [],
								wrg : [],
								"default" : []
							};
							if (!_BFD.BFD_INFO) {
								_BFD.BFD_INFO = {
									user_id : "",
									page_type : "dft"
								}
							}
							this.Tools = $Core.tools.Tools;
							var c = _BFD.BFD_INFO.user_id;
							var e = "C5173";
							f.options.cid = e;
							f.options.uid = c;
							if (typeof (f.options.uid) == "undefined"
									|| f.options.uid == ""
									|| f.options.uid == "0"
									|| f.options.uid == null) {
								f.options.uid = f.options.sid
							}
							this.info = _BFD.BFD_INFO;
							var d = this[this.info.page_type];
							if (d && typeof d === "function") {
								d.call(this, f)
							}
						}
						b.prototype = {
							detail : function(r) {
								r.options.p_t = "dt";
								var w = _BFD.BFD_INFO.id;
								var G = _BFD.BFD_INFO.name;
								var n = _BFD.BFD_INFO.link;
								var e = _BFD.BFD_INFO.image_link;
								var u = _BFD.BFD_INFO.simage_link;
								var z = parseFloat(_BFD.BFD_INFO.price)
										.toFixed(2);
								var y = _BFD.BFD_INFO.category;
								var q = _BFD.BFD_INFO.brand;
								var x = _BFD.BFD_INFO.onsale;
								var d = parseFloat(_BFD.BFD_INFO.stock)
										.toFixed();
								r.send(new BCore.inputs.Visit(w));
								var l = [];
								var t = y.length;
								for (var A = 0; A < t - 1; A++) {
									if (y[A][0] == "") {
										y.splice(A, 1)
									}
								}
								var D = navigator.appName;
								var m = navigator.appVersion;
								var k = m;
								if ((D == "Microsoft Internet Explorer" && k
										.indexOf("MSIE 7.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE 6.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE 8.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE7.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE6.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE8.0") != -1)) {
									if (y && y instanceof Array) {
										for (var A = 1; A < y.length - 1; A++) {
											l.push(y[A][0])
										}
									}
								} else {
									if (y && y instanceof Array) {
										for (var A = 1; A < y.length; A++) {
											l.push(y[A][0])
										}
									}
								}
								var F = l[l.length - 1];
								var h = l[0];
								var E = "";
								if (l.length == 5) {
									var E = l[2];
									var s = l[3]
								} else {
									if (l.length > 3) {
										var E = l[1];
										var s = l[2];
										if (l[1] == "") {
											var E = l[2];
											var s = l[3]
										}
									}
								}
								if (x == "false" || !x || d == 0 || G == ""
										|| n == "" || e == "") {
									r.send(new $Core.inputs.RmItem(w))
								} else {
									var o = new $Core.inputs.AddItem(w);
									o.name = G;
									o.tag = F;
									o.subtitle = h;
									if (E != "") {
										var C = new $Core.inputs.JObject();
										C.qu = E;
										C.fwq = s;
										o.attr = C.toString()
									}
									o.url = n;
									o.img = e;
									o.simg = u;
									o.prc = z;
									o.cat = l;
									o.stk = d;
									r.send(o)
								}
								if ((D == "Microsoft Internet Explorer" && k
										.indexOf("MSIE 7.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE 6.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE 8.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE7.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE6.0") != -1)
										|| (D == "Microsoft Internet Explorer" && k
												.indexOf("MSIE8.0") != -1)) {
									if (l.length > 0) {
										var j = l[l.length - 1];
										r.send(new $Core.inputs.VisitCat(l
												.join("$")));
										var p = new $Core.inputs.AddCat(j);
										if (y.length > 0) {
											p.url = y[y.length - 2][1];
											var v = y.concat();
											v.pop();
											v.splice(0, 1);
											p.ptree = new $Core.inputs.JObject()
													.toString(v);
											r.send(p)
										}
									}
								} else {
									if (l.length > 0) {
										var j = l[l.length - 1];
										r.send(new $Core.inputs.VisitCat(l
												.join("$")));
										var p = new $Core.inputs.AddCat(j);
										if (y.length > 0) {
											p.url = y[y.length - 1][1];
											var v = y.concat();
											v.pop();
											v.splice(0, 1);
											p.ptree = new $Core.inputs.JObject()
													.toString(v);
											r.send(p)
										}
									}
								}
								var f = new $Core.inputs.PageView();
								f.p_s = G;
								if (_BFD.banners["dt"]
										&& _BFD.banners["dt"].length > 0) {
									f.p_p = "rec";
									var c = new BCore.recommends.Recommend("P");
									c.unq = 1;
									c.iid = w;
									c.cat_cur = l.join("$");
									c.cat = l.join("$");
									var B = l.concat();
									B.pop();
									c.cat2 = B.join("$");
									_BFD.parseBanners(c, _BFD.banners["dt"], r)
								}
								r.send(f);
								var g = new $Core.inputs.AddUser();
								g.user_id = _BFD.BFD_USER.user_cookie;
								r.send(g)
							},
							list : function(n) {
								n.options.p_t = "ls";
								var e = _BFD.BFD_INFO.category;
								var k = [];
								if (e && e.length > 0) {
									for (var l = 0; l < e.length; l++) {
										k.push(e[l][0])
									}
									var g = e[e.length - 1][0];
									n.send(new $Core.inputs.VisitCat(k
											.join("$")));
									var f = new $Core.inputs.AddCat(g);
									f.url = e[e.length - 1][1];
									var h = e.concat();
									h.pop();
									f.ptree = new $Core.inputs.JObject()
											.toString(h);
									n.send(f)
								}
								var j = new $Core.inputs.PageView();
								if (_BFD.banners["ls"]
										&& _BFD.banners["ls"].length > 0) {
									j.p_p = "rec";
									var d = new BCore.recommends.Recommend("P");
									d.unq = 1;
									d.cat_cur = k.join("$");
									d.cat = k.join("$");
									var m = k.concat();
									m.pop();
									d.cat2 = m.join("$");
									_BFD.parseBanners(d, _BFD.banners["ls"], n)
								}
								n.send(j);
								var c = new $Core.inputs.AddUser();
								c.user_id = _BFD.BFD_USER.user_cookie;
								n.send(c)
							},
							shopcart : function(n) {
								n.options.p_t = "sc";
								var c = [];
								var k = this.Tools
										.mergeRepeat(_BFD.BFD_INFO.cart_items);
								if (k.length > 0) {
									var l = new $Core.inputs.AddCart();
									for (var g = 0; g < k.length; g++) {
										var m = k[g][0] + "";
										c.push(m);
										var j = this.Tools.toNumber(k[g][1]);
										var h = this.Tools.toNumber(k[g][2]);
										l.push({
											i : m,
											p : j,
											n : h
										})
									}
									n.send(l)
								}
								var f = new $Core.inputs.PageView();
								if (_BFD.banners["sc"]
										&& _BFD.banners["sc"].length > 0) {
									f.p_p = "rec";
									var e = new BCore.recommends.Recommend("P");
									e.unq = 1;
									e.iid = c;
									_BFD.parseBanners(e, _BFD.banners["sc"], n)
								}
								n.send(f);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								n.send(d)
							},
							order : function(q) {
								q.options.p_t = "odr";
								var o = _BFD.BFD_INFO.order_id;
								var n = _BFD.BFD_INFO.total;
								var l = _BFD.BFD_INFO.payment;
								var m = _BFD.BFD_INFO.express;
								var e = new $Core.inputs.Order(o);
								e.total = this.Tools.toNumber(n);
								var g = this.Tools
										.mergeRepeat(_BFD.BFD_INFO.order_items);
								for (var h = 0; h < g.length; h++) {
									if (Number(g[h][2]) > 0) {
										var p = g[h][0] + "";
										var k = this.Tools.toNumber(g[h][1]);
										var j = this.Tools.toNumber(g[h][2]);
										e.push({
											i : p,
											p : k,
											n : j
										})
									}
								}
								q.send(e);
								var f = new $Core.inputs.PageView();
								if (_BFD.banners["odr"]
										&& _BFD.banners["odr"].length > 0) {
									f.p_p = "rec";
									var d = new BCore.recommends.Recommend("P");
									d.unq = 1;
									_BFD
											.parseBanners(d,
													_BFD.banners["odr"], q)
								}
								q.send(f);
								var c = new $Core.inputs.AddUser();
								c.user_id = _BFD.BFD_USER.user_cookie;
								q.send(c)
							},
							homepage : function(f) {
								f.options.p_t = "hp";
								var c = new $Core.inputs.PageView();
								if (_BFD.banners["hp"]
										&& _BFD.banners["hp"].length > 0) {
									c.p_p = "rec";
									var e = new BCore.recommends.Recommend("P");
									e.unq = 1;
									_BFD.parseBanners(e, _BFD.banners["hp"], f)
								}
								f.send(c);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								f.send(d)
							},
							search : function(i) {
								i.options.p_t = "sr";
								var h = _BFD.BFD_INFO.search_word;
								var g = _BFD.BFD_INFO.search_result;
								var c = new $Core.inputs.PageView();
								var f = new $Core.inputs.Search(h);
								if (g == "0") {
									f.emp = 1;
									if (_BFD.banners["sr_n"]
											&& _BFD.banners["sr_n"].length > 0) {
										c.p_p = "rec";
										var e = new BCore.recommends.Recommend(
												"P");
										e.unq = 1;
										_BFD.parseBanners(e,
												_BFD.banners["sr_n"], i)
									}
								} else {
									f.emp = 0;
									if (_BFD.banners["sr_y"]
											&& _BFD.banners["sr_y"].length > 0) {
										c.p_p = "rec";
										var e = new BCore.recommends.Recommend(
												"P");
										e.unq = 1;
										_BFD.parseBanners(e,
												_BFD.banners["sr_y"], i)
									}
								}
								i.send(f);
								i.send(c);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								i.send(d)
							},
							account : function(g) {
								g.options.p_t = "ap";
								var c = new $Core.inputs.PageView();
								if (_BFD.banners["ap"]
										&& _BFD.banners["ap"].length > 0) {
									c.p_p = "rec";
									var f = new BCore.recommends.Recommend("P");
									f.unq = 1;
									var e = self.location.href;
									if (e.indexOf("*") != -1) {
										c.p_p = "rec";
										_BFD.parseBanners(f,
												_BFD.banners["ap"], g)
									}
								}
								g.send(c);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								g.send(d)
							},
							channel : function(g) {
								g.options.p_t = "chl";
								var e = _BFD.BFD_INFO.channel_name;
								var c = new $Core.inputs.PageView();
								if (_BFD.banners["chl"]
										&& _BFD.banners["chl"].length > 0) {
									c.p_p = "rec";
									var f = new BCore.recommends.Recommend("P");
									f.unq = 1;
									_BFD
											.parseBanners(f,
													_BFD.banners["chl"], g)
								}
								g.send(c);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								g.send(d)
							},
							payment : function(q) {
								q.options.p_t = "pm";
								var o = _BFD.BFD_INFO.order_id;
								var n = _BFD.BFD_INFO.total;
								var l = _BFD.BFD_INFO.payment;
								var m = _BFD.BFD_INFO.express;
								var e = new $Core.inputs.Pay(o);
								e.total = this.Tools.toNumber(n);
								var g = this.Tools
										.mergeRepeat(_BFD.BFD_INFO.order_items);
								for (var h = 0; h < g.length; h++) {
									if (Number(g[h][2]) > 0) {
										var p = g[h][0] + "";
										var k = this.Tools.toNumber(g[h][1]);
										var j = this.Tools.toNumber(g[h][2]);
										e.push({
											i : p,
											p : k,
											n : j
										})
									}
								}
								q.send(e);
								var f = new $Core.inputs.PageView();
								if (_BFD.banners["pm"]
										&& _BFD.banners["pm"].length > 0) {
									f.p_p = "rec";
									var d = new BCore.recommends.Recommend("P");
									d.unq = 1;
									_BFD.parseBanners(d, _BFD.banners["pm"], q)
								}
								q.send(f);
								var c = new $Core.inputs.AddUser();
								c.user_id = _BFD.BFD_USER.user_cookie;
								q.send(c)
							},
							others : function(f) {
								f.options.p_t = "dft";
								var c = new $Core.inputs.PageView();
								if (_BFD.banners["dft"]
										&& _BFD.banners["dft"].length > 0) {
									c.p_p = "rec";
									var e = new BCore.recommends.Recommend("P");
									e.unq = 1;
									_BFD
											.parseBanners(e,
													_BFD.banners["dft"], f)
								}
								f.send(c);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								f.send(d)
							},
							wrong : function(g) {
								g.options.p_t = "dft";
								var f = _BFD.BFD_INFO.id;
								g.send(new $Core.inputs.RmItem(f));
								var c = new $Core.inputs.PageView();
								if (_BFD.banners["wrg"]
										&& _BFD.banners["wrg"].length > 0) {
									c.p_p = "rec";
									var e = new BCore.recommends.Recommend("P");
									e.unq = 1;
									_BFD
											.parseBanners(e,
													_BFD.banners["wrg"], g)
								}
								g.send(c);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								g.send(d)
							},
							dft : function(e) {
								e.options.p_t = "dft";
								e.options.uid = e.options.sid;
								var c = new $Core.inputs.PageView();
								c.p_p = "";
								e.send(c);
								var d = new $Core.inputs.AddUser();
								d.user_id = _BFD.BFD_USER.user_cookie;
								e.send(d)
							}
						};
						return b
					})();
					new a()
				});