# haiku-sleep
Allow SmartThings to automate turning on sleep mode on a Haiku fan

This is a device handler for a [Haiku Fan](https://www.bigassfans.com/for-home/). I tried using the [handler by System48](https://community.smartthings.com/t/haiku-fan-senseme-two-way-assistance/40204) but was unable to get it to work with the new app including automations. Instead of trying to replicate that really I just wanted to turn on sleep mode on the fan when the hub goes into Night mode. So this is a super simple handler with just a big button that turns on sleep. There is no other functionality, not even turning off sleep. The button can be pressed by an automation.

Enjoy.

## Installation

Copy and paste the code into a new device handler. Create a device, setting the network id to the mac address of your fan without colons. Once created, edit the preferences adding the name of the device (as seen in Haiku app) or mac address, and the IP. You should probably give the fan a static IP in your router settings.
