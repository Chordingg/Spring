console.log("Reply Module..................")

var replyService = (function(){

    function add(reply, callback){
        console.log("reply................")

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

        // data : {
            // reply : '',
            // bno : bno,
        //}


    }   // End update

    function get(rno, callback, error){

        console("-------------------get");

        $.ajax({
            type:"get",
            url:"/reply/" +rno,

            success:function(data, status, xhr){
                if(callback){
                    callback(data)
                }
            },

            error:function(status, xhr, err){
                if(error){
                    error(err)
                }
            }
        })

    }



    return{
        add:add,
        getList:getList,
        remove:remove,
        update:update,
        get:get
    }
})();
 