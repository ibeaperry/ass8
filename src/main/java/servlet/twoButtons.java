/** *****************************************************************
    twoButtons.java   servlet example

        @author Jeff Offutt
********************************************************************* */
package servlet;

// Import Java Libraries
import java.io.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

// twoButtons class
// CONSTRUCTOR: no constructor specified (default)
//
// ***************  PUBLIC OPERATIONS  **********************************
// public void doPost ()  --> prints a blank HTML page
// public void doGet ()  --> prints a blank HTML page
// private void PrintHead (PrintWriter out) --> Prints the HTML head section
// private void PrintBody (PrintWriter out) --> Prints the HTML body with
//              the form. Fields are blank.
// private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
//              Prints the HTML body with the form.
//              Fields are filled from the parameters.
// private void PrintTail (PrintWriter out) --> Prints the HTML bottom
//***********************************************************************
@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/two"}
    )
public class twoButtons extends HttpServlet
{

// Location of servlet.
static String Domain  = "ass7swe432.herokuapp.com";
static String Path    = "/";
static String Servlet = "two";

/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the operation
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   String num = request.getParameter("number");
   String com = request.getParameter("Comments");
   String dov = request.getParameter("Date of Visit");
   String rat = request.getParameter("rating");
   String ln = request.getParameter("last_name");
   String fn = request.getParameter("fist_name");
   String email = request.getParameter("email");
   String building = request.getParameter("building");
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   out.println("<html>");
   out.println("<head>");
   out.println("<title>Bathroom Feedback Form</title>");
   out.println("</head>");
   out.println("<body>");
   out.println("<h2>Number: "+num+" </h2>");
   out.println("<h2>Comments: "+com+" </h2>");
   out.println("<h2>Date of Visit: "+dov+" </h2>");
   out.println("<h2>Rating: "+rat+" </h2>");
   out.println("<h2>Last Name: "+ln+" </h2>");
   out.println("<h2>First Name: "+fn+" </h2>");
   out.println("<h2>Email: "+email+" </h2>");
   out.println("<h2>Building: "+building+" </h2>");
   out.println("</body>");
   out.println("</html>");
 
}  // End doPost

/** *****************************************************
 *  Overrides HttpServlet's doGet().
 *  Prints an HTML page with a blank form.
********************************************************* */
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out);
   PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */
private void PrintHead (PrintWriter out)
{
   String sytles = "html,body {min-height: 100%;}body,div,form,input,select {padding: 0;margin: 0;outline: none;font-family: Roboto, Arial, sans-serif;font-size: 14px;color: #666;line-height: 22px;}h1,h4 {margin: 15px 0 4px;font-weight: 400;}h4 {margin: 20px 0 4px;font-weight: 400;}span {color: red;}.error{border:2px solid red;}.small {font-size: 10px;line-height: 18px;}.star-rating__stars {position: relative;height: 5rem;width: 25rem;background: url(data:image/png;base64,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);background-size: 5rem 5rem;}.star-rating__label {position: absolute;height: 100%;background-size: 5rem 5rem;}.star-rating__input {margin: 0;position: absolute;height: 1px; width: 1px;overflow: hidden;clip: rect(1px, 1px, 1px, 1px);}.star-rating__stars .star-rating__label:nth-of-type(1) {z-index: 5;width: 20%;}.star-rating__stars .star-rating__label:nth-of-type(2) {z-index: 4;width: 40%;}.star-rating__stars .star-rating__label:nth-of-type(3) {z-index: 3;width: 60%;}.star-rating__stars .star-rating__label:nth-of-type(4) {z-index: 2;width: 80%;}.star-rating__stars .star-rating__label:nth-of-type(5) {z-index: 1;width: 100%;}.star-rating__input:checked + .star-rating__label,.star-rating__input:focus + .star-rating__label,.star-rating__label:hover {background-image: url(data:image/png;base64,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);}.star-rating__label:hover ~ .star-rating__label {background-image: url(data:image/png;base64,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);}.star-rating__input:focus ~ .star-rating__focus {position: absolute;top: -.25em;right: -.25em;bottom: -.25em;left: -.25em;outline: 0.25rem solid lightblue;}.testbox {display: flex;justify-content: center;align-items: center;height: inherit;padding: 3px;}form {width: 100%;padding: 20px;background: #fff;box-shadow: 0 2px 5px #ccc;}input {width: calc(100% - 10px);padding: 5px;border: 1px solid #ccc;border-radius: 3px;vertical-align: middle;}input:hover,textarea:hover,select:hover {outline: none;border: 1px solid #095484;background: #e6eef7;}.title-block input {margin-bottom: 10px;}select {padding: 7px 0;border-radius: 3px;border: 1px solid #ccc;background: transparent;}select,table {width: 100%;}option {background: #fff;}.day-visited,.time-visited {position: relative;}input[type='date']::-webkit-inner-spin-button {display: none;}input[type='time']::-webkit-inner-spin-button {margin: 2px 22px 0 0;}.day-visited i,.time-visited i,input[type='date']::-webkit-calendar-picker-indicator {position: absolute;top: 8px;font-size: 20px;}.day-visited i,.time-visited i {right: 5px;z-index: 1;color: #a9a9a9;}[type='date']::-webkit-calendar-picker-indicator {right: 0;z-index: 2;opacity: 0;}.question-answer label {display: block;padding: 0 20px 10px 0;}.question-answer input {width: auto;margin-top: -2px;}th,td {width: 18%;padding: 15px 0;border-bottom: 1px solid #ccc;text-align: center;vertical-align: unset;line-height: 18px;font-weight: 400;word-break: break-all;}.first-col {width: 25%;text-align: left;}textarea {width: calc(100% - 6px);}.btn-block {margin-top: 20px;text-align: center;}button:disabled{background-color: #000;}button {width: 150px;padding: 10px;border: none;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;background-color: #095484;font-size: 16px;color: #fff;cursor: pointer;}button:hover:enabled {background-color: #0666a3;}@media (min-width: 568px) {.title-block {display: flex;}.title-block select {width: 30%;margin-bottom: 0;}.title-block input {width: 50%;margin-bottom: 0;margin-right: 10px;}th,td {word-break: keep-all;}.radio {width: 10px;}.checked {color: orange;}.unchecked {color: #000;}}";

   out.println("<html>");
   out.println("");

   out.println("<head>");
   out.println("<title>Bathroom Feedback Form</title>");
   out.println("<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet'>");
   out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>");
   out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>");
   out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + "styles.css" + "\">");
   out.println("</head>");
   out.println("");
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
{
   out.println("<body>");
   out.println("<div class='testbox'>");
   out.print  ("<form method=\"post\"");
   out.println(" action=\"https://" + Domain + Path + Servlet + "\">");
out.println("<h1>GMU Bathroom Feedback Form</h1>");
out.println("<h2> By: Michael Vanderlyn, and Chris Perry</h2>");
out.println("<h3>Name<span>*</span></h3>");
out.println("<div class='title-block'>");
out.println("<input class='name' type='text' name='fist_name' placeholder='First' />");
out.println("<input class='name' type='text' name='last_name' placeholder='Last' />");
out.println("</div>");
out.println("<h3>Email Address<span>*</span></h3>");
out.println("<input id='email' type='text' name='email' onkeyup='enableButton()'/>");
out.println("<h3>Contact Number (123-456-7890)<span>*</span></h3>");
out.println("<input id='number' type='text' name='number' onkeyup='enableButton()'/>");
out.println("<h3>Building<span>*</span></h3>");
out.println("<div class='building-block' id='build'>");
out.println("<select name='building' id='building' onchange='enableButton()'>");
out.println("<option value=''></option>");
out.println("<option value='Robinson'>Robinson</option>");
out.println("<option value='JC'>Johnson Center</option>");
out.println("<option value='Exploratory'>Exploratory</option>");
out.println("<option value='Innovation'>Innovation</option>");
out.println("<option value='Engineering'>Engineering Building</option>");
out.println("</select>");
out.println("</div>");
out.println("<h3>Date of Visit<span>*</span><h3>");
out.println("<input value='' type='date' id='visit' name='Date of Visit' onkeyup='validatedate()'/>");
out.println("<h3>Rating of Experience<span>*</span></h3>");
out.println("<fieldset class='star-rating'>");
out.println("<legend class='star-rating__title'>Your rating:</legend>");
out.println("<div class='star-rating__stars'>");
out.println("<input class='star-rating__input' type='radio' name='rating' value='1' id='rating-1' />");
out.println("<label class='star-rating__label' for='rating-1' aria-label='One'></label>");
out.println("<input class='star-rating__input' type='radio' name='rating' value='2' id='rating-2' />");
out.println("<label class='star-rating__label' for='rating-2' aria-label='Two'></label>");
out.println("<input class='star-rating__input' type='radio' name='rating' value='3' id='rating-3' />");
out.println("<label class='star-rating__label' for='rating-3' aria-label='Three'></label>");
out.println("<input class='star-rating__input' type='radio' name='rating' value='4' id='rating-4' />");
out.println("<label class='star-rating__label' for='rating-4' aria-label='Four'></label>");
out.println("<input class='star-rating__input' type='radio' name='rating' value='5' id='rating-5' />");
out.println("<label class='star-rating__label' for='rating-5' aria-label='Five'></label>");
out.println("<div class='star-rating__focus'></div>");
out.println("</div>");
out.println("</fieldset>");
out.println("<h3>Comments on experience</h3>");
out.println("<textarea rows='5' name='Comments' id='comment'></textarea>");
out.println("<div class='btn-block'>");
out.println("<button class='click' type='submit' id='push' onclick='checkComment()'>Enter Response</button>");
out.println("</div>");
out.println("<script>");
out.println("var button = document.getElementById('push');");
out.println("var clicker = document.getElementsByClassName('click')[0];");
out.println("function enableButton(){");
out.println("var empty = false;");
out.println("if(document.getElementById('building').value == ''){");
out.println("empty=true;");
out.println("}else if(document.getElementById('email').value == ''){");
out.println("empty=true; ");
out.println("}else if(document.getElementById('number').value == ''){");
out.println("empty=true; ");
out.println("}");
out.println("if(empty==false){");
out.println("button.disabled=false;");
out.println("}");
out.println("}");
out.println("function checkComment(){");
out.println("if(document.getElementById('comment').value == ''){");
out.println("console.log('comment empty');");
out.println("}else{");
out.println("console.log('goods');");
out.println("}");
out.println("}");
out.println("function validatedate(inputText) {");
out.println("var temp = document.getElementById('visit').value;");
out.println("document.getElementById('visit').valid = false;");
out.println("var temp2 = temp.split('-');");
out.println("console.log(temp2[0]); // year");
out.println("console.log(temp2[1]); // month");
out.println("console.log(temp2[2]); // day");
out.println("var newDate = new Date(temp2[0],temp2[1] - 1,temp2[2])");
out.println("console.log(newDate);");
out.println("var todaysDate = new Date();");
out.println("todaysDate.setHours(0,0,0,0);");
out.println("console.log(todaysDate.toDateString());");
out.println("console.log(todaysDate > newDate);");
out.println("if(todaysDate > newDate){");
out.println("document.getElementById('visit').className = document.getElementById('visit').className.replace(' error', '');");
out.println("}else{");
out.println("document.getElementById('visit').className = document.getElementById('visit').className + ' error';  // this adds the error class");
out.println("}");
out.println("}");
out.println("</script>");
out.println("</form>");
   out.println("</div>");
   out.println("</body>");
} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
private void PrintBody (PrintWriter out)
{
   PrintBody(out, "", "", "");
}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

}  // End twoButtons
