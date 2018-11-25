/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import edu.command.*;


/**
 *
 * @author Aeron
 */
public class Client{
  public static void main(String[] args)    {
    RemoteControl control = new RemoteControl();
    Light light = new Light();
    Command lightsOn = new edu.command.LightOnCommand(light);
    Command lightsOff = new edu.command.LightOffCommand(light);
    //switch on
    control.setCommand(lightsOn);
    control.pressButton();
    //switch off
    control.setCommand(lightsOff);
    control.pressButton();
  }
}