/**
 * JavaScript code for Client Side
 * Form validation.
 */
function validate(frm) {
   // read form data
   let name = frm.pname.value;
   let age = frm.page.value;
   let flag = true;
   
   // client side form validation logic
   if(name==""){
      alert("Person name is required");
      frm.pname.focus(); // focus the text box
      flag = false;
   } else if(name.length < 5) { // min length
      alert("Person name must have minimum of 5 Characters");
      frm.pname.focus(); // focus the text box
      flag = false;
   }
   if(age==""){
      alert("Person age is required");
      frm.page.focus(); // focus the text box
      flag = false;
   } else if(isNaN(age)) { // must be numeric
      alert("Person age is not a number");
      frm.page.focus(); // focus the text box
      flag = false;
   } else if(age<1 || age>125) { // age range 
      alert("Person age must be between 1 to 125");
      frm.page.focus(); // focus the text box
      flag = false;
   }
   return flag;
   // true => form is error free
   // false => form validation errors
}