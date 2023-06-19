

                                                            
DESCRIPTION = "Gateway Recipe"
LICENSE = "CLOSED"




SRC_URI = "git://github.com/samar12lassoued/gRPCProject.git;protocol=https;branch=main"
SRCREV= "3520f2d166ed17ffa287fe811ecae09186c7313c"

S = "${WORKDIR}/git"

RDEPENDS_${PN}= "\
        python3-grpcio \
        python3-paho-mqtt \
        python3-protobuf \
        python3-pmodbus \
"
        


do_install(){
   #install directories
	install -d ${D}/opt/MultiprotocolGateway
	install -d ${D}/etc/MultiprotocolGateway
	install -d ${D}${systemd_unitdir}/system/
	
	
   #install  systemd files
	install -d ${D}${systemd_unitdir}/system
    	install -m 0644 ${S}/systemd/Config_Manager.service ${D}${systemd_unitdir}/system
    	install -m 0644 ${S}/systemd/Mqtt_Manager.service ${D}${systemd_unitdir}/system
    	install -m 0644 ${S}/systemd/ModbusClient.service ${D}${systemd_unitdir}/system
 
       install -m 0644 ${S}/Config/Config.json ${D}/opt/MultiprotocolGateway
       install -m 0644 ${S}/*.py ${D}/etc/MultiprotocolGateway
       install -m 0644 ${S}/lib/*.py ${D}/etc/MultiprotocolGateway
    
    
       install -m 0644 ${S}/*.sh ${D}/opt/MultiprotocolGateway
       install -m 0644 ${S}/*.py ${D}/opt/MultiprotocolGateway
       install -m 0644 ${S}/lib/*.py ${D}/opt/MultiprotocolGateway
    
		
}



FILES_${PN} = "/opt/* /etc/* ${systemd_unitdir}/*"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "Config_Manager.service Mqtt_Manager.service ModbusClient.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"




