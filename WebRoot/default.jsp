<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>jQuery UI Autocomplete - Default functionality</title>
	<link rel="stylesheet" href="development-bundle/themes/base/jquery.ui.all.css">
	<script src="development-bundle/jquery-1.10.2.js"></script>
	<script src="development-bundle/ui/jquery.ui.core.js"></script>
	<script src="development-bundle/ui/jquery.ui.widget.js"></script>
	<script src="development-bundle/ui/jquery.ui.position.js"></script>
	<script src="development-bundle/ui/jquery.ui.menu.js"></script>
	<script src="development-bundle/ui/jquery.ui.autocomplete.js"></script>
	<link rel="stylesheet" href="development-bundle/demos/demos.css">
	<script>
	$(function() {
		var availableTags = [
			"ActionScript",
			"AppleScript",
			"Asp",
			"BASIC",
			"C",
			"C++",
			"Clojure",
			"COBOL",
			"ColdFusion",
			"Erlang",
			"Fortran",
			"Groovy",
			"Haskell",
			"Java",
			"JavaScript",
			"Lisp",
			"Perl",
			"PHP",
			"Python",
			"Ruby",
			"Scala",
			"Scheme"
		];
		( "#tagss" ).autocomplete({
			source: availableTags
		});
	});
	</script>
</head>
<body>

<div>
	<input id="tagss">
</div>

<div class="demo-description">
<p>The Autocomplete widgets provides suggestions while you type into the field. Here the suggestions are tags for programming languages, give "ja" (for Java or JavaScript) a try.</p>
<p>The datasource is a simple JavaScript array, provided to the widget using the source-option.</p>
</div>
</body>
</html>
