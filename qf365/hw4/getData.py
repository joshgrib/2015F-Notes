from yahoo_finance import Share
import datetime
import urllib
djia = ["AAP","AXP","BA","CAT","CSCO","CVX","DD","DIS","GE","GS","HD","IBM","INTC","JNJ","JPM","KO","MCD","MMM","MRK","MSFT","NKE","PFE","PG","TRV","UNH","UTX","V","VZ","WMT","XOM"]
base_url = "http://ichart.finance.yahoo.com/table.csv?s="

def make_url(ticker_symbol,start_date, end_date):
    print ticker_symbol
    a = start_date
    b = end_date
    dt_url = '%s&a=%d&b=%d&c=%d&d=%d&e=%d&f=%d&g=d&ignore=.csv'% (ticker_symbol, a.month-1, a.day, a.year, b.month-1, b.day,b.year)
    return base_url + dt_url

s = datetime.date(2010,1,1)
e = datetime.date(2014,12,31)

for ticker in djia:
    u =  make_url(ticker,s,e)
    file_location = './data/' + ticker + '.csv'
    urllib.urlretrieve(u, file_location)
