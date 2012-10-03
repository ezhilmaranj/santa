<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = application.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- Stylesheet-->

<%-- <link rel="stylesheet" type="text/css" href="<%=path%>/css/logica1.css" /> --%>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/style.css?v=2" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/text.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/layout.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/grid.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/superfish.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/jquery.tagsinput.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/jquery.treeview.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/fluid.gs.lt_ie8.css" />

<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/validationEngine.jquery.css" />

<!-- dataTable css -->
<link rel="stylesheet" href="<%=path%>/css/demo_table_jui.css">

<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/custom-theme/jquery-ui-1.8.13.custom.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/960.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/fluid.gs.css"
	media="screen" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/ie.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/ie6.css" />





<!-- Script  -->
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery.validationEngine-en.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery.validationEngine.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=path%>/js/hoverIntent.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.treeview.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-fluid16.js"></script>
<script type="text/javascript" src="<%=path%>/js/plugins.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/libs/modernizr-1.7.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/libs/dd_belatedpng.js"></script>
<script type="text/javascript" src="<%=path%>/js/script.js"></script>
<!-- modernizr -->
<script src="js/libs/modernizr-1.7.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/superfish.js"></script>
<script type="text/javascript" src="<%=path%>/js/supersubs.js"></script>

<!-- dataTable -->
<script type="text/javascript"
	src="<%=path%>/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
	$(function() {

		$("#fields div").draggable({
			appendTo : "body",
			revert: "invalid",
			helper : "clone"
		});
		
		$("#fields").droppable();	

		$("#droppable").droppable({
			activeClass : "ui-state-default",
			hoverClass : "ui-state-hover",
			accept : ":not(.ui-sortable-helper)",
			drop : function(event, ui) {
				$(this).append(ui.draggable);
			}
		}).sortable({
			items : "li:not(.placeholder)",
			sort : function() {
				// gets added unintentionally by droppable interacting with sortable
				// using connectWithSortable fixes this, but doesn't allow you to customize active/hoverClass options
				$(this).removeClass("ui-state-default");
			}
		});

		//treeview for inner menus
		$("#browser").treeview({
			toggle : function() {
				console.log("%s was toggled.", $(this).find(">span").text());
			}
		});

		// menu superfish
		$('#navigationTop').superfish();

		// tags
		$("#tags_input").tagsInput();

		// dataTable
		var uTable = $('#example').dataTable({
			"sScrollY" : 200,
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers"
		});
		$(window).bind('resize', function() {
			uTable.fnAdjustColumnSizing();
		});

		// Accordion
		$("#accordion").accordion({
			header : "h3"
		});

		// Accordion2
		$("#accordion2").accordion({
			header : "h3"
		});

		// Tabs
		$('#tabs').tabs();
		$('#tabsOut').tabs();

		// Dialog			
		$('#dialog').dialog({
			autoOpen : false,
			width : 600,
			buttons : {
				"Ok" : function() {
					$(this).dialog("close");
				},
				"Cancel" : function() {
					$(this).dialog("close");
				}
			}
		});

		// Dialog Link
		$('#dialog_link').click(function() {
			$('#dialog').dialog('open');
			return false;
		});

		// Datepicker
		$('.datepicker').datepicker({
			inline : true,
			dateFormat : 'yy/mm/dd'
		});

		// Slider
		$('#slider').slider({
			range : true,
			values : [ 17, 67 ]
		});

		// Progressbar
		$("#progressbar").progressbar({
			value : 20
		});

		//hover states on the static widgets
		$('#dialog_link, ul#icons li').hover(function() {
			$(this).addClass('ui-state-hover');
		}, function() {
			$(this).removeClass('ui-state-hover');
		});

	});
</script>

</head>
<body>
	<div class="container_16">
		<header>
		<div class="grid_16">
			<tiles:insertAttribute name="header" ignore="true" />
		</div>
		<div class="grid_16">
			<ul class="sf-menu" id="navigationTop">
				<tiles:insertAttribute name="menu" ignore="true" />
			</ul>
		</div>
		<div class="clear"></div>
		<div class="grid_16">
			<h2 id="page-heading">
				<tiles:insertAttribute name="page_heading" ignore="true" />
			</h2>
		</div>
		<div class="grid_16">
			<tiles:insertAttribute name="page_crumbs" ignore="true" />
		</div>
		<div class="clear"></div>
		</header>
		<div id="main" role="main">
			<div id="content">
				<div class="grid_16">
					<tiles:insertAttribute name="body" ignore="true" />
				</div>
			</div>
		</div>
		<footer>
		<div class="grid_16" id="site_info">
			<tiles:insertAttribute name="footer" ignore="true" />
		</div>
		</footer>
		<div class="clear"></div>
	</div>
</body>
</html>