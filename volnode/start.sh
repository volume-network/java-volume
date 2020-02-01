#!/bin/bash
PID=$(ps -ef|grep volume.jar| grep -v grep|awk '{printf $2}')

if [ "$PID" != "" ]; then
    kill -9 ${PID}
fi

echo "Start volume.jar..."
nohup java -cp volume.jar:conf vlm.Volume  > nohup.out  2>&1 &
