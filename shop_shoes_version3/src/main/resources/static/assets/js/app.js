class App {

    static DOMAIN = location.origin;

    static BASE_URL_AUTH = this.DOMAIN + "/api/auth";
    static BASE_URL_PRODUCT = this.DOMAIN + "/api/products";
    static BASE_URL_CATEGORY = this.DOMAIN + "/api/categories";
    static BASE_URL_SIZE = this.DOMAIN + "/api/sizes";
    static BASE_URL_COLOR = this.DOMAIN + "/api/colors";

    static BASE_URL_CLOUD_IMAGE = "https://res.cloudinary.com/ngocbich/image/upload";
    static BASE_SCALE_IMAGE = "c_limit,w_150,h_100,q_100";

    static SweetAlert = class {
        static showSuccessAlert(t) {
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: t,
                showConfirmButton: false,
                timer: 2500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                position: 'middle',
                icon: 'error',
                title: t,
                showConfirmButton: false,
                timer: 2500
            })
        }

        static ShowConfirmSuspend(t) {
            return Swal.fire({
                position: 'middle',
                icon: 'warning',
                title: t,
                showCancelButton: true,
                confirmButtonText: 'Yes, delete it!',
                cancelButtonText: 'No, cancel!',
                reverseButtons: true
            });
        }
    }

    static IziToast = class {
        static showSuccessAlert(t) {
            iziToast.show({
                title: 'Success',
                message: t,
                position: 'topRight',
                color: 'green',
                timeout: 2500,
            });
        }

        static showErrorAlert(t) {
            iziToast.show({
                title: 'Error',
                message: t,
                position: 'topRight',
                color: 'red',
                timeout: 2500,
            });
        }
    }

}

class Product {
    constructor(id, name, title, price, material, quantity, hot, bestseller, status,
                sizeId, size,
                colorId, color,
                categoryId, nameCategory, description,
                fileId, fileName, fileFolder) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
        this.material = material;
        this.quantity = quantity;
        this.hot = hot;
        this.bestseller = bestseller;
        this.status = status;
        this.sizeId = sizeId;
        this.size = size;
        this.colorId = colorId;
        this.color = color;
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.description = description;
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileFolder = fileFolder;
    }
}

class Category {
    constructor(id, title) {
        this.id = id;
        this.title = title;
    }
}

class Size {
    constructor(id, size) {
        this.id = id;
        this.size = size;
    }
}

class ColorJS {
    constructor(id, color) {
        this.id = id;
        this.color = color;
    }
}




