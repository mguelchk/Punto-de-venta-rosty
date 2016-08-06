function Acceder() {


    var user = $("#txtUsuario").val();
    var password = $("#txtPass").val();
    if (user == "") {
        alert("Necesita agregar un uasuario");
    } else if (password == "") {
        alert("Necesita agregar una contraeña");
    } else {
        validaUser(user, password);
    }
}
function validaUser(user, password) {
    $.post("/PuntoVenta/Sesion", {
        user: user,
        password: password
    }, function (res) {

        var respuesta = [];
        respuesta = res.split(",");
        if (respuesta[0] == "1") {
            location.href = respuesta[1];
        } else {
            alert(res);
        }
    });

}

function getProductos() {
    $("#idImagen").css("display", "block ");
    $.post("/PuntoVenta/SolicitudProducto", {
        opcion: 1
    }, function (res) {
        $("#idImagen").css("display", "none ");
        $("#tblProTable").html(res);
    });
}

function addProdut() {
    var clave = $("#txtClave").val();
    var nombre = $("#txtNombre").val();
    var precio = $("#txtPrecio").val();
    var existencia = $("#txtExistencia").val();
    var idProdcuto = $("#txtIdProducto").val();
    if (clave == "") {
        alert("Necesita agregar un uasuario");
    } else if (nombre == "") {
        alert("Necesita agregar una contraeña");
    }
    if (precio == "") {
        alert("Necesita agregar un uasuario");
    } else {
        inserProdcut(clave, nombre, precio, existencia, idProdcuto);
    }
}
function inserProdcut(clave, nombre, precio, existencia, idProdcuto) {
    if (validaFloat(precio)) {
        if (existencia == "") {
            existencia = 1;
        }
        if (idProdcuto == "id") {
            $.post("/PuntoVenta/SolicitudProducto", {
                opcion: 2,
                clave: clave,
                nombre: nombre,
                precio: precio,
                existencia: existencia
            }, function (res) {
                alert(res);
                clearFields();
                getProductos();
            });
        } else {
            $.post("/PuntoVenta/SolicitudProducto", {
                opcion: 4,
                clave: clave,
                nombre: nombre,
                precio: precio,
                existencia: existencia,
                idProdcuto: idProdcuto
            }, function (res) {
                alert(res);
                getProductos();
            });
        }


    } else {
        alert("El valor del precio no es valido");
    }

    function validaFloat(numero) {
        if (!/^([0-9])*[.]?[0-9]*$/.test(numero))
            return false;
        else
            return  true;
    }
}
function clearFields() {
    $("#txtClave").val("");
    $("#txtNombre").val("");
    $("#txtPrecio").val("");
    $("#txtExistencia").val("");
}

function  editarProduct(idProdcuto) {
    $.post("/PuntoVenta/SolicitudProducto", {
        opcion: 3,
        idProdcuto: idProdcuto
    }, function (res) {

        var respuesta = [];
        respuesta = res.split("$$");
        $("#btnAddUp").val("Actualizar");
        $("#btnAddUp").css("background-color", "red");
        $("#txtIdProducto").val(respuesta[0]);
        $("#txtClave").val(respuesta[1]);
        $("#txtNombre").val(respuesta[2]);
        $("#txtPrecio").val(respuesta[3]);
        $("#txtExistencia").val(respuesta[4]);

    });
}

function eliminarProdut(idProdcuto) {
        var confirmacion = confirm("¿Estas seguro de eliminat el sigueinmte regstro? ");
        if (confirmacion) {
            $.post("/PuntoVenta/SolicitudProducto", {
                opcion: 5,
                idProdcuto: idProdcuto
            }, function (res) {
                alert(res);
                getProductos();
            });
        }
    }
