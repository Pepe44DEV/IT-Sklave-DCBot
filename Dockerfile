FROM maven:adoptopenjdk

RUN ["git", "clone", "https://github.com/Pepe44DEV/IT-Sklave-DCBot", "bot"]
ENV TOKEN token
WORKDIR "bot/"
RUN ["chmod", "+x", "install.sh"]
ENTRYPOINT ["./install.sh"]