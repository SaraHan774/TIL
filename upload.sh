#!/usr/bin/env zsh

cd $HOME/tmp
eval $(ssh-agent)
ssh-add ~/.ssh/id_rsa
git add .
git commit -m $1 
git push origin master