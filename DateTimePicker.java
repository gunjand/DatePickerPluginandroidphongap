public class DateTimePicker extends CordovaPlugin {
	public static final String ACTION_FILE_UPLOAD = "datetimepickeraction";
	static final int DATE_DIALOG_ID = 0;
	static final int TIME_DIALOG_ID = 1;

	// variables to save user selected date and time
	public int year, month, day, hour, minute;
	// declare the variables to Show/Set the date and time when Time and Date
	// Picker Dialog first appears
	private int mYear, mMonth, mDay, mHour, mMinute;

	private MainActivity activity;

	public DateTimePicker() {
		// Assign current Date and Time Values to Variables
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);
	}

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);

		// Set the Activity.
		this.activity = (MainActivity) cordova.getActivity();
	}

	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {

		try {
			if (ACTION_FILE_UPLOAD.equals(action)) {
			
				JSONObject arg_object = args.getJSONObject(0);
				int DialogType = arg_object.getInt("intValue");
				showDialog(DialogType, callbackContext);

				return true;
			}
			
			return false;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;

		}

	}

	private void showDialog(int dialogType, CallbackContext callbackContext) {
		// TODO Auto-generated method stub
		Log.d("Enter", "Enter");

		this.activity.callActivityMethod(dialogType, callbackContext);

	}

}
