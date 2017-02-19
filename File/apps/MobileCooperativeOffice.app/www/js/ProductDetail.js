function PrductDetailService(){
    this.setUI = function(){
        
        
        blankcount = 8;
        blank = '';
        if(window.screen.width == 414) blankcount = 6;
        for (var i = 0; i < blankcount; i++) {
            blank += '&nbsp;';
        }
        $("#telephone").html('电' + blank + '话');
        $("#email").html('邮' + blank + '箱');
        
        
        setColseAndOpenDiv('Control_chanpinjieshao', 'Applicant_informationList2', 'chanpinjieshao');
        setColseAndOpenDiv('Control_shuxing', 'Applicant_informationList5', 'shuxing');
    }
    this.setProdcutDesc = function(index){
        document.getElementById('productDesc').innerHTML = index;
    }

    this.setPropertyDiv = function(index){
        setNomalRowDivDataWriteByPTag('Applicant_informationList5',index);
    }

}

var productDetailService = new PrductDetailService();

window.onload=function(){
    productDetailService.setUI();
    
}



