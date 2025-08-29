/**
 * 
 */


var target = document.querySelector('img');

target.onclick= fn_onclick;
target.addEventListener("mouseover", fn_onmouseover);
target.addEventListener("mouseover", fn_onmouseover2);
//target.onmouseover = fn_onmouseover;
//target.onmouseout = fn_onmouseout;



function fn_onclick(event)
{
	console.log(event);
	alert("이미지 클릭");
	for(var i = 0; i < 10; i++)
	{
		console.log(i);
	}
	
}




function fn_onmouseover(event)
{
	target.src="img/user.png";
	console.log("mouseover");
}


function fn_onmouseover2(event)
{
	console.log("onmouseover2지롱");
	target.removeEventListener("mouseover", fn_onmouseover2);
}



function fn_onmouseout(event)
{
	console.log("fn_onmouseout");
	event.target.src="img/html_logo.png";
}