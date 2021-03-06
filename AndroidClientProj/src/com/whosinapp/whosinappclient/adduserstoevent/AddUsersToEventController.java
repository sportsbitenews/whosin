package com.whosinapp.whosinappclient.adduserstoevent;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.text.Editable;

import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.models.User;

public class AddUsersToEventController {

	AddUsersToEventActivity _myActivity;

	public AddUsersToEventController(AddUsersToEventActivity mainActivity) {
		_myActivity = mainActivity;
	}

	public void addUsersToEvent(int eventId, ArrayList<Integer> userIds) throws ClientProtocolException, IOException{
		
		AddUsersToEventDto dto = new AddUsersToEventDto();
		
		dto.setEventId(eventId);
		dto.setUserIds(userIds);
		
		ServiceGateway theGate = new ServiceGateway();
		
		theGate.Send(dto);
		
	}
	
	public User searchForUserByEmail(Editable emailAddress)
			throws ClientProtocolException, IOException, JSONException {

		String email = emailAddress.toString();

		SearchForUserByEmailDto myDto = new SearchForUserByEmailDto();
		myDto.setEmail(email);

		ServiceGateway theGate = new ServiceGateway();

		User user = theGate.Send(myDto);

		
		return user;

	}

}
