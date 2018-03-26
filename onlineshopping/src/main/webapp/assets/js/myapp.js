$(function() {

	// solving active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#list').addClass('active');
		break;

	default:
		if (menu == "Home") break;
		$('#list').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	//code for jquey Datatable
	//create a dataset
	/*var products = [
		
		
		['1','ABC'],
		['2','DFG'],
		['3','HJK'],
		['4','LMN'],
		['5','OPQ'],
		['6','RST'],
		['7','VWY'],
		['8','XVY'],
		['9','ALC']
		
	];*/
	
	var $table = $('#productListTable');
	
	//execute this code below only when we have this table
	if($table.length){
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			
			jsonUrl = window.context + '/json/data/all/products';
		}
		
		else {
		      jsonUrl = window.context + '/json/data/category/'+window.categoryId+'/products';
	         }
		
		//console.log('Inside the datatable');
		$table.dataTable({
			//serverSide : true,
			lengthMenu : [[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
			pageLength : 5,
			//data : products
			ajax : {
				
				url : jsonUrl,
				dataSrc : ''
			
			},
			
			columns : [
				

				{
					
					data : 'code',
					mRender : function(data , type, row){
						
						return '<img src="'+window.context+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				{
					
					data : 'name'
				},
                {
					
					data : 'brand'
				},
                {
					
					data : 'unitPrice',
					mRender : function(data , type , row){
						
						return '&#8377; ' + data;
					}
				},
               {
					
					data : 'quantity',
					mRender : function(data , type , row){
						
						if (data < 1) {
							return '<span style="color:red">Out of Stock!</span>';
						}

						return data;
					}
				},
                {
					
					data : 'id',
					bSortable : false,
					mRender : function(data , type , row){
						
						var str = '';
						str +='<a href="'+window.context+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						if (row.quantity < 1){
							
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							
						}
						
						else{
							
							str +='<a href="'+window.context+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

						}
						
						return str;
					}
				}
				
			]
		});
		
		
	}
});