var DateTimePicker = {
	    createEvent: function(intValue,successCallback, errorCallback) {
	        cordova.exec(
	            successCallback, // success callback function
	            errorCallback, // error callback function
	            'DateTimePicker', 
	            'datetimepickeraction',
	            [{               
	               
	                  
	            	"intValue":intValue
	               
	                
	            }]
	        ); 
	    }
	}
