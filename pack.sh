#!/bin/bash

cp volume.jar volnode/.
mkdir -p volnode/html/ui/js/3rdparty
cp html/ui/js/3rdparty/jquery.min.js volnode/html/ui/js/3rdparty/
cp html/ui/js/3rdparty/bootstrap.min.js volnode/html/ui/js/3rdparty/
cp html/ui/css/bootstrap.min.css volnode/html/ui/css/
tar cvzf volnode.tar.gz volnode
