        $(document).ready(function() {
        	
        	var contextPath = $('[name="contextPath"]').val();
    		var urlTarget = contextPath + "/sell/sell.do";
        	
        	$('.message a').click(function(){
        		   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
        		});
        	
            $(".register-form [name='sellMemAccount']").blur(function() {
            	var input = $(this);
            	console.log("value = " + $(this).val());
    			$.ajax({
    				url: urlTarget,
    				type: "POST",
    				data: {
    					"action": "checkIsExist",
    					"colName": "SELL_MEM_ACCOUNT",
    					"checkValue" : $(this).val(),
    				},
    				success: function(data) {
    					var re = JSON.parse(data);
    					console.log("data.valid = " + re.valid);
    					if(re.valid === false){
    						// 帳號已存在
    						swal({
    							  title: "Try again",
    							  text: "帳號已存在，請重新輸入",
    							  icon: "warning",
    							  dangerMode: true,
    							})
    					}
    				}
    			});
            })

        })