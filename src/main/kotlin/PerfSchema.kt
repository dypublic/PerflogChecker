package checker

var format = """
process.duration	total process time, unit is ms		Required
process	derby process type	MUST BE:GetAvailability	Required
process.supplier	supplier process type(for exampel, we receive a modify from channel and need to do cancel and rebook.	For Example: OTA_HotelAvail	Required
process.result	process result	Success, Fail	Required
availability.result	if there are no any room is available, should be NoAvail, if process.type is Fail, should be NoAvail	Avail or NoAvail	Required
cache	cache get availability	True or False	Optional
supplier	derby supplier code	string,upper case	Required on supplier end
channel	derby channel code	string,upper case	Required on channel end
hotel.supplier	supplier hotel code	string	Required on supplier end for single hotel
hotel.channel	channel hotel code	string	Required on channel end for single hotel
hotel.derby	derby hotel code	string	Optional
echo.token	unique id for the request	string	Optional
check.in	checkin,format is 2015-12-24	string	Optional
check.out	checkout, format is 2015-12-24	string	Optional
adult.cnt	adult count	number 1-9	Optional
children.cnt	children count	number 1-9	Optional
children.ages	children ages. Format is 10,6	string	Optional
room.cnt	room count	number 1-99	Optional
los	length of stay	number	Optional
iata	IATA send to supplier	number string	Optional
"""

class FieldProps(var name: String, )

class GetAvailability {
    var name: String = "GetAvailability"

}