console.log("Reply Module..................")

var replyService = (function(){

    function add(reply, callback){
        console.log("add reply................")

		// 비동기 통신
		// {reply:"JS Test", replyer:"tester", bno:bnoValue}
        $.ajax({
            type:"post",
            url:"/reply/new",
            data:JSON.stringify(reply),
            contentType:"application/json; charset=utf-8",
            
            success:function(result,status,xhr){
                if(callback){
                    callback(result)
                }
            },
           
            error: function(xhr, status, er){
                if(error){
                    error(er)
                }
            }
        })
    };  //End end
    
    

    function getList(param, callback, error){
    
    	console.log("bno & page......... : " ,param.bno , "," , param.page);
    
        var bno = param.bno;

        var page = param.page || 1

        $.ajax({
            type:"get",
            url:"/reply/pages/" + bno + "/" + page,

            success:function(list, status, xhr){
                if(callback){
                    callback(list)
                }
            },

            error:function(xhr,status,err){
                if(error){
                    error();
                }
            }
        })
    }   // End getList
    
    

    function remove(rno, callback, error){
    	
    	console.log("remove Rno : " + rno);
    	
        $.ajax({
            type:"delete",
            url:"/reply/" + rno,
            success:function(msg, status, xhr){
                if(callback){
                    callback(msg)
                }
            },
            error:function(xhr, status, er){
                if(error){
                    error(er)
                }
            }
        })
    }   // End remove
    
    

    function update(reply, callback, error){
    
        console.log("update Rno : " + reply.rno);

        $.ajax({
            type:"put",
            url:"/reply/" + reply.rno,
            data:JSON.stringify(reply),
            contentType:"application/json; charset=utf-8",
            
            success:function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr,status,er){
                if(error){
                    error(er);
                }
            }
        });
    }   // End update


   
  function get(rno,callback, error){
		console.log("get..............")

		$.ajax({
			type: "get",
			url: "/reply/" + rno,

			success: function(data, status, xhr){
				if(callback){
					callback(data)
				}
			},
			error: function(status, xhr, err){
				if(error){
					error(err)
				}
			}
		})
	} // End get
    
    
    
    function displayTime(timeValue){
    
    
    	var today = new Date();
    	
    	var gap = today.getTime() - timeValue;
    	
    	var dateObj = new Date(timeValue);
    	
    	var str = "";
    		
    		// 24시간 - 하루가 안지났다면 시간으로 표시
    	if(gap < (1000 * 60 * 60 * 24)){
    		var hh = dateObj.getHours();
    		var mi = dateObj.getMinutes();
    		var ss = dateObj.getSeconds();
    		
    		// 예를 들어 10시 2분 22초라면 => 10:02:22
    		return [(hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join('');
    		
    		// 하루가 지났다면 날짜로 표시
    	}else{
    		var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
    		
    		return [ (yy > 9 ? '' : '0') + yy, ':', (mm>9 ? '' : '0')	+ mm, ':', (dd>9? '' : '0') + dd ].join('');
    	}
    };	// End displayTime
    
    
    
    return{
        add:add,
        getList:getList,
        remove:remove,
        update:update,
        get:get,
        displayTime:displayTime
    };
})();
 