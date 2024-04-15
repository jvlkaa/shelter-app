import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BreedViewComponent } from './breed-view.component';

describe('BreedViewComponent', () => {
  let component: BreedViewComponent;
  let fixture: ComponentFixture<BreedViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BreedViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BreedViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
