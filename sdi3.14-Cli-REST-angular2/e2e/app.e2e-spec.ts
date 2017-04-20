import { Sdi3.14CliRESTAngular2Page } from './app.po';

describe('sdi3.14-cli-rest-angular2 App', () => {
  let page: Sdi3.14CliRESTAngular2Page;

  beforeEach(() => {
    page = new Sdi3.14CliRESTAngular2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
