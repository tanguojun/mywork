function (){
	if(this.x!=null&&this.x!=undefined){
		return;
	}
	for(var i = 0 ; i < this.x.length ; i++){
		emit(this.x[i],1);
	}
}