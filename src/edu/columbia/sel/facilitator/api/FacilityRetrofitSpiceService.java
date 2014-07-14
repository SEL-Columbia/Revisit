package edu.columbia.sel.facilitator.api;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.octo.android.robospice.retrofit.RetrofitJackson2SpiceService;

/**
 * Defines the RoboSpice Service which actually handles the management of requests.
 * 
 * @author Jonathan Wohl
 *
 */
public class FacilityRetrofitSpiceService extends RetrofitJackson2SpiceService {

	private static String BASE_URL = "http://23.21.86.131:3000/api/v1";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(FacilitatorApi.class);
    }

    @Override
    protected String getServerUrl() {
    	SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		return sharedPref.getString("facility_server_url", BASE_URL);
    }
    
    @Override
	public int getThreadCount() {
    	return 4;
    }
}
