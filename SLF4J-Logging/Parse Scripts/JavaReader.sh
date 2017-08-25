#!/bin/sh
#
# Grep the performance information from the Catalina log into a CSV file that can be graphed

logDir="C:/Users/intern3/Desktop/logs"

outputFile="logs/NovStarREST-memory.csv"

# Typical line is:
# Aug 23, 2017 9:28:40 AM JDK14Logger main
# INFO: MaxMemory=0.37486203187173694 TotalMemory=0.5021489582306498 FreeMemory=0.07321677006912242 AvailableProcessor=0.9174905200341374
# Typical line is:
# 21-Jul-2017 02:03:53.645 INFO [http-nio-8080-exec-2] systems.trilynx.ws.novastar.api.v1.SystemStatusFilter.filter MaxMemory=518979584 TotalMemory=129892352 FreeMemory=76250984 AvailableProcessor=1
#
echo "DateTime,MaxMemory,TotalMemory,FreeMemory" > ${outputFile}
for f in ${logDir}/logging_file.log
	do
	echo "Processing ${f}..."
	grep TotalMemory ${f} | awk '
	{
		# Split the line into tokens using space as delimiter
		n=split($0,tokens," ")
		maxMemory=""
		totalMemory=""
		freeMemory=""
		for ( i=1; i <= n; i++ ) {
			# Date is first
			if ( i == 1 ) {
				n2=split(tokens[i],array2,"-")
				dateISO8601=sprintf("%02d-%02d-%02d",array2[2],array2[3],array2[1])
			}
			else if ( i == 2 ) {
				n2=split(tokens[i],array2,":")
				timeISO8601=sprintf("%02d:%02d:%02d",array2[1],array2[2],array2[3])
			}
			# See if the item contains the values of interest
			if ( (index(tokens[i], "MaxMemory") == 1) && (index(tokens[i],"=") > 1) ) {
				n2=split(tokens[i],array2,"=")
				maxMemory=array2[2]
			}
			else if ( (index(tokens[i], "TotalMemory") == 1) && (index(tokens[i],"=") > 1) ) {
				n2=split(tokens[i],array2,"=")
				totalMemory=array2[2]
			}
			else if ( (index(tokens[i], "FreeMemory") == 1) && (index(tokens[i],"=") > 1) ) {
				n2=split(tokens[i],array2,"=")
				freeMemory=array2[2]
			}
		}
		# TODO smalers 2017-07-21 for now leave out T before time until TSTool can handle
		printf("%s %s,%s,%s,%s\n", dateISO8601, timeISO8601, maxMemory, totalMemory, freeMemory)
	}
	' >> ${outputFile}
done

