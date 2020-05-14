/**
 *  Haiku Sleep
 *
 *  Copyright 2020 GRAHAM CLENAGHAN
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 */
 preferences {
	input("devname", "text", title: "Device Name", description: "The devices name",required:true)
	input("destIp", "text", title: "IP", description: "The device IP",required:true)
 }
 
metadata {
	definition (name: "Haiku Sleep", namespace: "gclenaghan", author: "GRAHAM CLENAGHAN", cstHandler: true) {
		capability "Momentary"
	}

	simulator {
	}
}

def parse(String description) {
	log.debug "Parsing '${description}'"
}

def push() {
    def hosthex = convertIPtoHex(destIp)
    def porthex = convertPortToHex(31415)
    device.deviceNetworkId = "$hosthex:$porthex"
    def hubAction = new physicalgraph.device.HubAction("<$devname;SLEEP;STATE;ON>",physicalgraph.device.Protocol.LAN)
    log.debug "sleep pushed, sending ${hubAction} to $destIp:31415"
    hubAction
}

private String convertIPtoHex(ipAddress) { 
    String hex = ipAddress.tokenize( '.' ).collect {  String.format( '%02X', it.toInteger() ) }.join()
    return hex
}

private String convertPortToHex(port) {
	String hexport = port.toString().format( '%04X', port.toInteger() )
    return hexport
}
