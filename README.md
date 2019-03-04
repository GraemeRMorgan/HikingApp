![GitHub Logo](https://github.com/GraemeRMorgan/HikingApp/blob/master/arc-logo-soft.jpg)
#  ARCTrails
###### Ayla Wickham, Ryley Jewsbury, Caleigh LePage, Graeme Morgan, Reece Milliner
###### CPSC499

> ARCtrails was conceived by [@wickhama](https://github.com/wickhama) for CPSC 300 | Software Engineering at UNBC. The project was then exteneded to Agile Development | CPSC 499 and 400. 

ARCtrails is a concept for a social network focussed on sharing hiking trails. It is an application for android devices that allows you to locate, share, and create hiking trails in the
Prince George area. Upon download, it provides a list of local trails for users to locate and
walk/hike depending on their eagerness for adventure.

The app includes detailed meta-data about the hiking trails, including: 
* User uploaded images.
* Difficulty
* Length
* Description of the trail.
* User notes on the trail, such as 'Bring bugspray!'

The app also includes entended features, such as:

* Flagging innapropriate trails. 
* Adding points of interest on trails. 

The app is written in Java using Android Studio for development. Our team integrated Firebase and its realtime database feature in order to access trail information within the cloud. It utilizes the Google Maps API for GPS tracking and utilizes the GPXparser library to load trails from files. 

Both the main project as well as test projects are included in the repository

### Following is a list of classes, with simplified functionality documentation
---------------------------------------------------------------
****Detailed documentation can be found in the source code.****
---------------------------------------------------------------
```verbatim 
AlertUtils
	Increment3:
		Handles pop-up messages
		
Coordinates
	Increment1:
		Displays user's coordinates
	Increment3:
		Allows coordinates to be recorded
		
CustomMapFragment
	Increment1:
		Displays the user's position
	Increment2:
		Displays trails
	Increment3:
		Modified to zoom in on selected trails
		
GPXFile
	Increment2:
		Uses the GPXParser library to load trails from files
	Increment3:
		Uses the GPXParser library to write a trail to a file
		
initAssets
	Increment2:
		Loads files onto the user's device

LocationPermissionListener
	Increment1:
		Listens for results of permission requests

LocationRequestListener
	Increment1:
		Asks the user for location permission

MenuActivity		--(Main)
	Increment1:
		Handles permission requests
	Increment2:
		Allows the user to select a trail to view
	Increment3:
		Allows the user to record and save trails

NewTrailActivity
	Increment3:
		Gathers information for a trail file
		
TrailDataActivity
	Increment2:
		Displays information about a trail```
    
 ![GitHub Logo](https://github.com/GraemeRMorgan/HikingApp/blob/master/arc-1.jpg)
  ![GitHub Logo](https://github.com/GraemeRMorgan/HikingApp/blob/master/arc-3.jpg)
