# StramBase-Eventflow-Parser
Parses .sbapp document automatically created by StreamBase
Supported operations: Aggregation / Map(Projection) / Join / Filter(Selection) 

Everything should be specifacally named where they should not overlap one another. 

Exp: InputStream1 and then InputStream in the same query is not applicable because InputStream overlaps at InputStream1. Same for the operations.So InputStreams and operations should be named as InputStream0,InputStream1,InputStream2,......InputStream9 and for checking query with more than 10 nodes naming should continue with some letters: InputStreamA,InputStreamB... 
Filter operation condition should be something like: "AField < 25". Empty spaces before and after condtion.

