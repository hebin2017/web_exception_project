/**
 * list\u5de6\u53f3\u9009\u62e9
 * @fileOverview
 * @ignore
 */define("bui/extensions/multiselect/multiselect",["bui/common","bui/extensions/multiselect/multilist","bui/extensions/multiselect/multilistpicker","bui/extensions/search"],function(e){var t=e("bui/common"),n=t.Component,r=e("bui/extensions/multiselect/multilist"),i=e("bui/extensions/multiselect/multilistpicker"),s=e("bui/extensions/search"),o=t.prefix+"select-input",u=n.Controller.extend({initializer:function(){var e=this,t=e.get("search"),n=e.get("searchTpl"),i={},o;t&&(n&&(i.tpl=n),t=new s(i),o=[t]);var u=new r({items:e.get("items"),url:e.get("url"),plugins:o});e.set("multilist",u)},renderUI:function(){var e=this,t=e.get("el"),n=t.find("."+o),r=e.get("multilist"),s=new i({trigger:n,autoRender:!0,textField:n,valueField:e.get("valueField"),children:[r]});e.set("picker",s),e.set("textField",n)},bindUI:function(){var e=this,t=e.get("multilist");t.on("selected",function(t){var n=t.items;return e.fire("selected",{items:n})}),t.on("unselected",function(t){var n=t.items;return e.fire("unselected",{items:n})})}},{ATTRS:{elCls:{value:"bui-select"},searchTpl:{},search:{},url:{},items:{},source:{getter:function(){return this.get("multilist").get("source")}},target:{getter:function(){return this.get("multilist").get("target")}},valueField:{setter:function(e){return $(e)}},textField:{},tpl:{view:!0,value:'<input type="text" readonly="readonly" class="'+o+'"/><span class="x-icon x-icon-normal"><i class="icon icon-caret icon-caret-down"></i></span>'}}},{xclass:"multiselect"});return u});