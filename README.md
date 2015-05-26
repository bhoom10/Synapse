# Synapse
EEG monitor based on NeuroSky, made at Dexter hackathon.

There are 3 aspects of this project:
1. Reading brain waves and sending them to an Android device via bluetooth. This is done by the NeuroSky Mindwave headset.
2. Receiving these values in an Android app and storing the mean over a certain period of time into a file on the device.
3. Reading values from the file and plotting them in the form of a graph on the app. The inbuilt library GraphView has been used for the same. 
