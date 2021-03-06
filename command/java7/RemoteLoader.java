public class RemoteLoader {

	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");
		TV tv = new TV("Living Room");
		HotTub hotTub = new HotTub("Patio");

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);

		TVOnCommand tvOn = new TVOnCommand(tv);
		TVOffCommand tvOff = new TVOffCommand(tv);

		HotTubOnCommand hotTubOn = new HotTubOnCommand(hotTub);
		HotTubOffCommand hotTubOff = new HotTubOffCommand(hotTub);

		Command[] partyOn = { livingRoomLightOn, stereoOnWithCD, tvOn, hotTubOn };
		Command[] partyOff = { livingRoomLightOff, stereoOff, tvOff, hotTubOff };

		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(3, ceilingFanHigh, ceilingFanOff);
		remoteControl.setCommand(4, stereoOnWithCD, stereoOff);
		remoteControl.setCommand(5, partyOnMacro, partyOffMacro);

		System.out.println(remoteControl);

		remoteControl.onButtonWasPressed(0);
		remoteControl.offButtonWasPressed(0);
		remoteControl.onButtonWasPressed(1);
		remoteControl.offButtonWasPressed(1);

		remoteControl.onButtonWasPressed(2);
		remoteControl.offButtonWasPressed(2);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPressed();

		remoteControl.onButtonWasPressed(3);
		remoteControl.undoButtonWasPressed();
		System.out.println(remoteControl);

		remoteControl.onButtonWasPressed(4);
		remoteControl.offButtonWasPressed(4);

		System.out.println("--- Pushing Macro On. Party Mode, Engage ---");
		remoteControl.onButtonWasPressed(5);
		System.out.println("--- Pushing Macro Off. Party Successful ---");
		remoteControl.offButtonWasPressed(5);

	}

}
