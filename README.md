# inditex

##############

1- infrastructure\      # son los elementos externos con los que se comunica la aplicación, tanto de entrada como de salida.
        repository\     # Aqui irá la implementacion de los Repository
        controller\  

2- application\         #  En esta capa solemos tener los casos de uso, también llamados acciones o servicios de aplicación.
        impl\
        ports\          # Interfaces de service\
3-domain\               #  Aquí es donde se encuentra la lógica de negocio
        ports\    # Interfaces de repository
        service\    # Lógica de negocio
        model\      # modelos de dominio

##############

