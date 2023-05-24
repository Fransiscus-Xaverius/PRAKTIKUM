$(document).ready(function () {
	cetakpanel();
	var gold = 10;
	$("#goldtext").text("Gold : " + gold + "G");
	var Row = new Array();
	var Panel = new Array();
	var Rowinvent = new Array();
	var panelinvent = new Array();
	var Rowshop = new Array();
	var panelshop = new Array();
	var inventoryCapacity = 6;
	var plant = false;
	var water = false;
	var harvest = false;
	var peach = false;
	var peachSeed = 5;
	var peachGrow = 1;
	var peachPrice = 10;
	var lemon = false;
	var lemonSeed = 10;
	var lemonGrow = 2;
	var lemonPrice = 25;
	var banana = false;
	var bananaSeed = 20;
	var bananaGrow = 3;
	var bananaPrice = 50;

	function cetakpanel() {
		for (let i = 0; i < 3; i++) {
			var row = $('<div class="rowPanel"></div>');
			$("#lahan").append(row);
		}
		Row = $(".rowPanel");
		for (let i = 0; i < Row.length; i++) {
			var curRow = Row[i];
			$(curRow).attr("id", "rowPanel" + i);
			for (let i = 0; i < 3; i++) {
				var panel = $('<button class="Gridlahan"></button>');
				$(curRow).append(panel);
			}
		}
		Panel = $(".Gridlahan");
		for (let i = 0; i < Panel.length; i++) {
			var curPanel = Panel[i];
			$(curPanel).attr("id", "panel" + i);
		}

		for (let i = 0; i < 2; i++) {
			var row = $('<div class="rowInventory"></div>');
			$("#Inventbody").append(row);
		}

		Rowinvent = $(".rowInventory");
		for (let i = 0; i < Rowinvent.length; i++) {
			var curRow = Rowinvent[i];
			$(curRow).attr("id", "rowInventory" + i);
			for (let i = 0; i < 3; i++) {
				var panel = $('<button class="inventoryGrid"></button>');
				$(curRow).append(panel);
			}
		}
		
		panelinvent = $(".inventoryGrid");
		for (let i = 0; i < panelinvent.length; i++) {
			var curPanel = panelinvent[i];
			$(curPanel).attr("id", "inventory" + i);
		}

		for (let i = 0; i < 1; i++) {
			var row = $('<div class="rowShop"></div>');
			$("#bodyShop").append(row);
		}
		Rowshop = $(".rowShop");
		for (let i = 0; i < Rowshop.length; i++) {
			var curRow = Rowshop[i];
			$(curRow).attr("id", "rowShop" + i);
			for (let i = 0; i < 3; i++) {
				var panel = $('<button class="shopGrid"></button>');
				$(curRow).append(panel);
			}
		}
		
		arrShopPanel = $(".shopGrid");
		for (let i = 0; i < arrShopPanel.length; i++) {
			var curPanel = arrShopPanel[i];
			$(curPanel).attr("id", "shop" + i);
		}

		$("#shop0").css({
			"background-image": "url(assets/biji_persik.png)",
			"background-position": "center",
			"background-repeat": "no-repeat",
			"background-size": "55%",
		});
		$("#shop1").css({
			"background-image": "url(assets/biji_lemon.png)",
			"background-position": "center",
			"background-repeat": "no-repeat",
			"background-size": "55%",
		});
		$("#shop2").css({
			"background-image": "url(assets/biji_pisang.png)",
			"background-position": "center",
			"background-repeat": "no-repeat",
			"background-size": "55%",
		});
	}

	$("#planttool").click(function () {
		if (plant == false) {
			$("#planttool").css("text-decoration", "underline");
			currentTool = "plant";
			plant = true;
			resetAction(currentTool);
		} else {
			$("#planttool").css("text-decoration", "none");
			currentTool = null;
			plant = false;
		}
	});

	$("#waterTool").click(function () {
		if (water == false) {
			$("#waterTool").css("text-decoration", "underline");
			currentTool = "water";
			water = true;
			resetAction(currentTool);
		} else {
			$("#waterTool").css("text-decoration", "none");
			currentTool = null;
			water = false;
		}
	});

	$("#harvestTool").click(function () {
		if (harvest == false) {
			$("#harvestTool").css("text-decoration", "underline");
			currentTool = "harvest";
			harvest = true;
			resetAction(currentTool);
		} else {
			$("#harvestTool").css("text-decoration", "none");
			currentTool = null;
			harvest = false;
		}
	});

	var currentPlant = null;
	function resetPlant(x) {
		if (x == "peach") {
			$("#shop1").css("border", "none");
			lemon = false;
			$("#shop2").css("border", "none");
			banana = false;
		}
		if (x == "lemon") {
			$("#shop0").css("border", "none");
			peach = false;
			$("#shop2").css("border", "none");
			banana = false;
		}
		if (x == "banana") {
			$("#shop0").css("border", "none");
			peach = false;
			$("#shop1").css("border", "none");
			lemon = false;
		}
	}

	$("#shop0").click(function () {
		if (peach == false) {
			$("#shop0").css("border", "5px solid black");
			currentPlant = "peach";
			peach = true;
			$("#priceLabel").text("Price: " + peachSeed + "G");
			resetPlant(currentPlant);
		} else {
			$("#shop0").css("border", "none");
			currentPlant = null;
			peach = false;
			$("#priceLabel").text("Price: ");
		}
	});

	$("#shop1").click(function () {
		if (lemon == false) {
			$("#shop1").css("border", "5px solid black");
			currentPlant = "lemon";
			lemon = true;
			$("#priceLabel").text("Price: " + lemonSeed + "G");
			resetPlant(currentPlant);
		} else {
			$("#shop1").css("border", "none");
			currentPlant = null;
			lemon = false;
			$("#priceLabel").text("Price: ");
		}
	});

	$("#shop2").click(function () {
		if (banana == false) {
			$("#shop2").css("border", "5px solid black");
			currentPlant = "banana";
			banana = true;
			$("#priceLabel").text("Price: " + bananaSeed + "G");
			resetPlant(currentPlant);
		} else {
			$("#shop2").css("border", "none");
			currentPlant = null;
			banana = false;
			$("#priceLabel").text("Price: ");
		}
	});

	function action(currentPanel) {
		if (currentTool == "plant" && currentPlant != null) {
			var num = $("#goldtext").text().match(/\d+/g);
			var tempGold = parseInt(num[0]);
			if (currentPlant == "peach") {
				if (tempGold >= peachSeed && currentPanel.css("background-image") == "none") {
					tempGold -= peachSeed;
					currentPanel.css({
						"background-image": "url(assets/biji_persik.png)",
						"background-position": "center",
						"background-repeat": "no-repeat",
						"background-size": "55%",
					});
					currentPanel.attr("value", "peach" + 0);
					$("#goldtext").text("Gold : " + tempGold + "G");
				} else {
					if (tempGold < peachSeed) {
						alert("Tidak cukup uang");
					} else {
						alert("Mana bisa menanam bibit kaya gitu 🗿");
					}
				}
			} else if (currentPlant == "lemon" && currentPanel.css("background-image") == "none") {
				if (tempGold >= lemonSeed) {
					tempGold -= lemonSeed;
					currentPanel.css({
						"background-image": "url(assets/biji_lemon.png)",
						"background-position": "center",
						"background-repeat": "no-repeat",
						"background-size": "55%",
					});
					currentPanel.attr("value", "lemon" + 0);
					$("#goldtext").text("Gold : " + tempGold + "G");
				} else {
					if (tempGold < lemonSeed) {
						alert("Tidak cukup uang");
					} else {
						alert("Mana bisa menanam bibit kaya gitu 🗿");
					}
				}
			} else {
				if (tempGold >= bananaSeed && currentPanel.css("background-image") == "none") {
					tempGold -= bananaSeed;
					currentPanel.css({
						"background-image": "url(assets/biji_pisang.png)",
						"background-position": "center",
						"background-repeat": "no-repeat",
						"background-size": "55%",
					});
					currentPanel.attr("value", "banana" + 0);
					$("#goldtext").text("Gold : " + tempGold + "G");
				} else {
					if (tempGold < bananaSeed) {
						alert("Tidak cukup uang");
					} else {
						alert("Mana bisa menanam bibit kaya gitu 🗿");
					}
				}
			}
		}
		if (currentTool == "water") {
			if (currentPanel.css("background-color") != "#00FFFF") {
				currentPanel.css("background-color", "#00FFFF");
			}
		}
		if (currentTool == "harvest") {
			panelinvent = $(".inventoryGrid");
			var type = currentPanel.attr("value").match(/[a-zA-Z]+/g);
			var age = currentPanel.attr("value").match(/\d+/g);

			var safe = false;

			if (type == "peach") {
				if (age >= peachGrow) {
					safe = true;
				}
			} else if (type == "lemon") {
				if (age >= lemonGrow) {
					safe = true;
				}
			} else if (type == "banana") {
				if (age >= bananaGrow) {
					safe = true;
				}
			}

			if (safe) {
				if (inventoryCapacity >= 2) {
					for (let i = 0; i < 2; i++) {
						var index = -1;
						for (let j = 0; j < 6; j++) {
							var temp = "#inventory" + j;
							if ($(temp).attr("value") == undefined) {
								index = j;
								break;
							}
						}
						if (index != -1) {
							var temp2 = "#inventory" + index;
							$(temp2).attr("value", type);
							$(temp2).css({
								"background-position": "center",
								"background-repeat": "no-repeat",
								"background-size": "55%",
							});
							if (type == "peach") {
								$(temp2).css("background-image", "url(assets/persik.png)");
							} else if (type == "lemon") {
								$(temp2).css("background-image", "url(assets/lemon.png)");
							} else {
								$(temp2).css("background-image", "url(assets/pisang.png)");
							}
							inventoryCapacity -= 1;
						}
					}
					currentPanel.css("background-image", "none");
					currentPanel.removeAttr("value");
				} else {
					alert("Inventory full!");
				}
			} else {
				alert("Has Not Grown to Its Full Potential!");
			}
		}
	}

	$("#panel0").click(function () {
		action($("#panel0"));
	});
	$("#panel1").click(function () {
		action($("#panel1"));
	});
	$("#panel2").click(function () {
		action($("#panel2"));
	});
	$("#panel3").click(function () {
		action($("#panel3"));
	});
	$("#panel4").click(function () {
		action($("#panel4"));
	});
	$("#panel5").click(function () {
		action($("#panel5"));
	});
	$("#panel6").click(function () {
		action($("#panel6"));
	});
	$("#panel7").click(function () {
		action($("#panel7"));
	});
	$("#panel8").click(function () {
		action($("#panel8"));
	});
	
	$("#buttonnextday").click(function () {
		Panel = $(".Gridlahan");
		for (let i = 0; i < Panel.length; i++) {
			var el = $(Panel[i]);
			if (el.attr("value") != undefined && el.css("background-color") == "rgb(0, 255, 255)") {
				var type = el.attr("value").match(/[a-zA-Z]+/g);
				var age = parseInt(el.attr("value").match(/\d+/g));
				age += 1;
				el.attr("value", type + age);
			} else {
				if (el.attr("value") != undefined && el.css("background-color") != "rgb(0, 255, 255)") {
					var type = el.attr("value").match(/[a-zA-Z]+/g);
					var age = parseInt(el.attr("value").match(/\d+/g));
					if (type == "peach") {
						if (age < peachGrow) {
							age = 0;
						}
					} else if (type == "lemon") {
						if (age < lemonGrow) {
							age = 0;
						}
					} else {
						if (age < bananaGrow) {
							age = 0;
						}
					}
					el.attr("value", type + age);
				}
			}
			el.css("background-color", "white");
		}

		for (let i = 0; i < Panel.length; i++) {
			var el = $(Panel[i]);
			if (el.attr("value") != undefined) {
				var type = el.attr("value").match(/[a-zA-Z]+/g);
				var age = parseInt(el.attr("value").match(/\d+/g));
				console.log(type + " - " + age);
				if (type == "peach") {
					if (age >= peachGrow) {
						el.css("background-image", "url(assets/pohon_persik.png)");
					}
				} else if (type == "lemon") {
					if (age >= lemonGrow) {
						el.css("background-image", "url(assets/pohon_lemon.png)");
					}
				} else {
					if (age >= bananaGrow) {
						el.css("background-image", "url(assets/pohon_pisang.png)");
					}
				}
			}
		}

		currentTool = null;
		plant = false;
		$("#planttool").css("text-decoration", "none");
		water = false;
		$("#waterTool").css("text-decoration", "none");
		harvest = false;
		$("#harvestTool").css("text-decoration", "none");
		currentPlant = null;
		peach = false;
		$("#shop0").css("border", "none");
		lemon = false;
		$("#shop1").css("border", "none");
		banana = false;
		$("#shop2").css("border", "none");
		$("#priceLabel").text("Price:");

		alert("Next Day!");
	});
	function sell(currentItem) {
		var tempGold = parseInt($("#goldtext").text().match(/\d+/g));
		var type = currentItem.attr("value");
		if (type == "peach") {
			tempGold += peachPrice;
		} else if (type == "lemon") {
			tempGold += lemonPrice;
		} else if (type == "banana") {
			tempGold += bananaPrice;
		}
		currentItem.css("background-image", "none");
		currentItem.removeAttr("value");
		$("#goldtext").text("Gold : " + tempGold + "G");
		inventoryCapacity += 1;
	}
	
	$("#inventory0").click(function () {
	sell($("#inventory0"));
	});
	$("#inventory1").click(function () {
		sell($("#inventory1"));
	});
	$("#inventory2").click(function () {
		sell($("#inventory2"));
	});
	$("#inventory3").click(function () {
		sell($("#inventory3"));
	});
	$("#inventory4").click(function () {
		sell($("#inventory4"));
	});
	$("#inventory5").click(function () {
		sell($("#inventory5"));
	});

});