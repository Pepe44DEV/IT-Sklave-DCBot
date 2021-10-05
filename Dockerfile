FROM maven:adoptopenjdk

RUN ["git", "clone", "https://github.com/Pepe44DEV/IT-Sklave-DCBot", "bot"]

WORKDIR "bot/"

ENTRYPOINT ["./install.sh"]