package org.vvgaming.harmegido.server;

import java.util.ArrayList;
import java.util.List;

import org.unbiquitous.uos.core.InitialProperties;
import org.unbiquitous.uos.core.adaptabitilyEngine.Gateway;
import org.unbiquitous.uos.core.applicationManager.CallContext;
import org.unbiquitous.uos.core.driverManager.UosDriver;
import org.unbiquitous.uos.core.messageEngine.dataType.UpDriver;
import org.unbiquitous.uos.core.messageEngine.dataType.UpService.ParameterType;
import org.unbiquitous.uos.core.messageEngine.messages.Call;
import org.unbiquitous.uos.core.messageEngine.messages.Response;

public class ServerDriver implements UosDriver {

	private UpDriver definition;

	public ServerDriver() {
		definition = new UpDriver("uos.harmegido.server");
		definition.addService("sendMessage").addParameter("message", ParameterType.MANDATORY);
	}

	@Override
	public void init(Gateway gateway, InitialProperties properties, String instanceId) {
		
	}

	@Override
	public UpDriver getDriver() {
		return definition;
	}

	@Override
	public List<UpDriver> getParent() {
		return new ArrayList<UpDriver>();
	}

	@Override
	public void destroy() {
	}

	public void sendMsg(Call call, Response response, CallContext callContext) {
		System.out.println(call.getParameterString("msg"));
	}

}