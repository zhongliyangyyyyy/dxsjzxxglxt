var vm=new Vue({
	el:"#app",
	data:{
		message:"编号"
	},
	filters:{

	},
	mounted:function(){
		this.creatList();
	},
	method:{
		creatList:function(){
			this.$http.post("http://localhost:8081/springmvc_mybatis/dshlb",{},{emulateJSON: true}).then(function(res){
				
			});
		}
	}
});