/**
 * JavaScript code for Client Side
 * Form validation.
 */
 
function validate(frm) {
    /* REMOVE COMMENT FROM THE BELOW TWO LINES
     * AFTER KNOWING THE PROBLEM.
     */
	// document.getElementById("pnameErr").innerHTML="";
	// document.getElementById("pageErr").innerHTML="";
	
	//read from data
	var name = frm.pname.value;
	var age = frm.page.value;
	// write client side form validation logic
	if (name == "") {
		document.getElementById("pnameErr").innerHTML =
			"<b>Person name is required</b>";
		frm.pname.focus();
		return false;
	}
	if (age == "") {
		document.getElementById("pageErr").innerHTML =
			"<b>Person age is required</b>";
		frm.page.focus();
		return false;
	} else if (isNaN(age)) {
		document.getElementById("pageErr").innerHTML =
			"<b>Person age must be numeric value</b>";
		frm.page.focus();
		return false;
	} else {
		if (age <= 0 || age > 125) {
			document.getElementById("pageErr").innerHTML =
				"<b>Person age must be between 1 to 125</b>";
			frm.page.focus();
			return false;
		}
	}
	return true;
}