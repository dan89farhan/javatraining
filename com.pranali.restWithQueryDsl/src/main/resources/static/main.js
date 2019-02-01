
//Brand
var Brand = Backbone.Model.extend();

var BrandList = Backbone.Collection.extend({
    model: Brand,

    url: "http://localhost:8080/getBrand"
});

var BrandView = Backbone.View.extend({
    tagName: "option",

    render: function () {
        this.$el.append(this.model.get('brandName'));
        this.$el.attr('value', (this.model.get('brandName')));
        return this;
    }
});

var BrandListView = Backbone.View.extend({
    el: '#productBrand',
    initialize: function () {
        var _thisView = this;
        // this.model.fetch().done(function () {
        //     _thisView.render();
        //     console.log(_thisView);

        // });
        _.bindAll(this, "render");
        this.model.fetch({
            success: function (response, collection) {
                _thisView.render();

            }
        });
    },

    render: function () {
        var self = this;
        this.model.each(function (a) {
            var bv = new BrandView({ model: a });
            self.$el.append(bv.render().$el);
            //console.log(self.$el.html());

        });
        return self;
    }
});
var listOfBrand = new BrandList();
var listView = new BrandListView({ model: listOfBrand });
console.log(listView);



//Category
var Category = Backbone.Model.extend();

var CategoryList = Backbone.Collection.extend({
    model: Category,

    url: "http://localhost:8080/getCategory"
});

// var c1 = new Category({ name: 'cat1' });
// var c2 = new Category({ name: 'cat2' });
// var c3 = new Category({ name: 'cat3' });
// var listOfCategory = new CategoryList();
// listOfCategory.add(c1);
// listOfCategory.add(c2);
// listOfCategory.add(c3);

var CategoryView = Backbone.View.extend({
    tagName: "span",

    render: function () {
        this.$el.append("<input type='checkbox' name= productCategory" + " value=" + this.model.get("categoryName") + ">" + this.model.get("categoryName"));
        console.log(this.model.get("categoryName"));


        return this;
    }
});

var CategoryListView = Backbone.View.extend({
    el: '#categoryContainer',
    initialize: function () {
        var _thisView = this;
        // this.model.fetch().done(function () {
        //     _thisView.render();
        //     console.log(_thisView);

        // });
        _.bindAll(this, "render");
        this.model.fetch({
            success: function (response, collection) {
                _thisView.render();

            }
        });
    },

    render: function () {
        var self = this;
        this.model.each(function (a) {
            var cv = new CategoryView({ model: a });
            self.$el.append(cv.render().$el);
        });
        return self;
    }
});
var listOfCategory = new CategoryList();
var catListView = new CategoryListView({ model: listOfCategory });


//Form
var FormView = Backbone.View.extend({
    events: {
        'click .addButton': 'addProduct'
    },

    type: "post",

    addProduct: function () {
        $("#addButton").html('Add Product');
        console.log("click");
        var nameVar = $('#productName').val();
        $('#productName').val('');
        var priceVar = $('#productPrice').val();
        $('#productPrice').val('');
        var brandVar = $('#productBrand').val();
        $('#productBrand').val('');
        var dateVar = $('#mgfDate').val();
        $('#mgfDate').val('');
        var descriptionVar = $('#productDescription').val();
        $('#productDescription').val('');
        var categoryVar = [];
        $.each($("input[name='productCategory']:checked"), function () {
            categoryVar.push($(this).val());
            $('input[name=productCategory]').attr('checked', false);
        });
        var cat = categoryVar.join(",");
        var typeVar = $("input[name='productType']:checked").val();

        // console.log(nameVar);
        // console.log(priceVar);
        // console.log(brandVar);
        // console.log(dateVar);
        // console.log(descriptionVar);
        // console.log(categoryVar.join(','));
        // console.log(typeVar);


        tableList.add(new RowModel({ name: nameVar, price: priceVar, brand: brandVar, date: dateVar, description: descriptionVar, category: cat, type: typeVar }));


    },

    render: function () {
        var radioNew = "<input type='radio' name='productType' value='New'>New ";
        var radioRefurbished = "<input type='radio' name='productType' value='Refurbished'>Refurbished ";
        var radioOld = "<input type='radio' name='productType' value='Old'>Old ";

        this.$el.append("<br>Product Name: <input type='text' id='productName'> <br>");
        this.$el.append("Product Price: <input type='number' id='productPrice'> <br>");
        this.$el.append(" <br>");
        //this.$el.append("Product Category:" + catListView.render().$el.html() + " <br>");
        this.$el.append("Mgf Date : <input type='date' id='mgfDate'  data-date='' data-date-format='DD MMMM YYYY'> <br>");
        this.$el.append("Product Type:" + radioNew + " " + radioRefurbished + " " + radioOld + "<br>");
        this.$el.append("Product Description: <textarea id='productDescription'> </textarea> <br>");
        this.$el.append("<button class='addButton' id='addButton'>Add Product</button> <br>");
        return this;
    }
});

var form = new FormView({ el: '#formContainer' });
form.render();




//Table 
var RowModel = Backbone.Model.extend({
    defaults: {
        name: 'NA',
        price: 0,
        brand: 'NA',
        category: 'NA',
        date: 'NA',
        type: 'NA',
        description: 'NA'
    },

    urlRoot: "http://localhost:8080/Product"
});

var TableModel = Backbone.Collection.extend({
    url: "http://localhost:8080/getProduct",

    model: RowModel,

    initialize: function (options) {
        return Backbone.Collection.prototype.fetch.call(this, options);
    }
});

var tableList = new TableModel();

var RowView = Backbone.View.extend({
    tagName: "tr",


    //type: "delete",

    events: {
        'click .deleteButton': 'deleteFromList',
        'click .editButton': 'editList'
    },

    deleteFromList: function (row) {
        tableList.remove(this.model.cid);
        console.log("In model: ", this.model);

        this.model.destroy();

    },

    editList: function (row) {
        $('#productName').val(this.model.get("name"));
        $('#productPrice').val(this.model.get("price"));
        $('#productBrand').val(this.model.get("brand"));
        $('#mgfDate').val(this.model.get("date"));
        $('#productDescription').val(this.model.get("description"));
        var array = this.model.get("category").split(",");
        for (i = 0; i < array.length; i++) {
            $('input[name=productCategory][value=' + array[i] + ']').prop('checked', true);
        }
        $('[name=productType]').val([this.model.get("type")]);
        $("#addButton").html('Update Product');
        tableList.remove(this.model.cid);


    },

    saveToDb: function () {

        this.model.save({ url: RowModel.urlRoot });
    },

    render: function () {
        this.$el.attr('id', (this.model.cid));

        var name = this.model.get("name");
        var price = this.model.get("price");
        var brand = this.model.get("brand");
        var category = this.model.get("category");
        var date = moment(this.model.get("date")).format("Do MMM YY");
        var type = this.model.get("type");
        var description = this.model.get("description");

        this.$el.append("<td>" + name + "</td>");
        this.$el.append("<td>" + price + "</td>");
        this.$el.append("<td>" + brand + "</td>");
        this.$el.append("<td>" + category + "</td>");
        this.$el.append("<td>" + date + "</td>");
        this.$el.append("<td>" + type + "</td>");
        this.$el.append("<td title = " + description + "  class='description'>" + description + "</td>");
        this.$el.append("<td> <button class='editButton'>Edit</button></td>");
        this.$el.append("<td><button class='deleteButton'>Delete</button></td>");
        if (type == 'New') {
            console.log("New");
            this.$el.css("background-color", "red");
        }
        else if (type == 'Old') {
            console.log('Old');
            this.$el.css("background-color", "green");
        }
        else if (type == 'Refurbished') {
            console.log("re");
            this.$el.css("background-color", "blue");

        }

        console.log(this.model);

        return this;
    }
});



var TableView = Backbone.View.extend({
    initialize: function () {
        this.model.on('add', this.onListAdded, this);
        this.model.on('remove', this.onListRemove, this);
    },

    onListAdded: function (ele) {
        var row = new RowView({ model: ele });
        this.$el.append(row.render().$el);
         row.saveToDb();
    },

    onListRemove: function (ele) {
        this.$('tr#' + ele.cid).remove();

    },

    render: function () {
        var self = this;
        this.model.each(function (a) {
            var rv = new RowView({ model: a });
            self.$el.append(rv.render().$el);
        });
        return self;
    }
});

var obj = new TableView({ el: '#tableContainer', model: tableList });
obj.render();
