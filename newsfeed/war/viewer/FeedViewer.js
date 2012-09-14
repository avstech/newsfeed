/**
 * @class FeedViewer.FeedViewer
 * @extends Ext.container.Viewport
 *
 * The main FeedViewer application
 * 
 * @constructor
 * Create a new Feed Viewer app
 * @param {Object} config The config object
 */

Ext.define('FeedViewer.App', {
    extend: 'Ext.container.Viewport',
    
    initComponent: function(){
        
        Ext.define('Feed', {
            extend: 'Ext.data.Model',
            fields: ['title', 'url']
        });

        Ext.define('FeedItem', {
            extend: 'Ext.data.Model',
            fields: ['title',  {
                name: 'pubDate',
                type: 'date'
            }, 'link', 'description', 'content']
        });
        
        Ext.apply(this, {
            layout: {
                type: 'border',
                padding: 5
            },
            items: [this.createFeedPanel(), this.createFeedInfo()]
        });
        this.callParent(arguments);
    },
    
    /**
     * Create the list of fields to be shown on the left
     * @private
     * @return {FeedViewer.FeedPanel} feedPanel
     */
    createFeedPanel: function(){
        this.feedPanel = Ext.create('widget.feedpanel', {
            region: 'west',
            collapsible: true,
            width: 225,
            //floatable: false,
            split: true,
            minWidth: 175,
            feeds: [{
                title: 'Yahoo News',
                url: 'http://news.yahoo.com/rss'
            }, {
                title: 'CNN News',
                url: 'http://rss.cnn.com/rss/edition.rss'
            }, {
                title: 'BBC',
                url: 'http://feeds.bbci.co.uk/news/rss.xml'
            }],
            listeners: {
                scope: this,
                feedselect: this.onFeedSelect
            }
        });
        return this.feedPanel;
    },
    
    /**
     * Create the feed info container
     * @private
     * @return {FeedViewer.FeedInfo} feedInfo
     */
    createFeedInfo: function(){
        this.feedInfo = Ext.create('widget.feedinfo', {
            region: 'center',
            minWidth: 300
        });
        return this.feedInfo;
    },
    
    /**
     * Reacts to a feed being selected
     * @private
     */
    onFeedSelect: function(feed, title, url){
        this.feedInfo.addFeed(title, url);
    }
});
